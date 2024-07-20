package io.github.subhamtyagi.openinwhatsapp

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.ClipboardManager
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.ialokim.phonefield.PhoneInputLayout
import com.google.android.material.color.DynamicColors

import com.google.i18n.phonenumbers.PhoneNumberUtil
import io.github.subhamtyagi.openinwhatsapp.prefs.Prefs
import java.io.UnsupportedEncodingException
import java.net.URISyntaxException
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {

    companion object {
        private const val PICK_CONTACT = 1
    }

    private lateinit var pickBtn: Button
    private var isShare = false
    private lateinit var mPhoneInput: PhoneInputLayout
    private lateinit var shareMsg: EditText
    private lateinit var shareBtn: Button
    private lateinit var mBtnLink: TextView
    private lateinit var paste: ImageView
    private var number: String = ""
        set(value) {
            field = value.replace(Regex("[^+\\d]"), "")
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DynamicColors.applyToActivityIfAvailable(this)
        setContentView(R.layout.main_activity)

        // Check if the activity was started with the "CONTACTS" action
        if (intent?.action == "io.github.subhamtyagi.openinwhatsapp.CONTACTS") {
            pick()
        }
        initUI()
    }

    override fun onStart() {
        super.onStart()
        val action = intent?.action
        if (Intent.ACTION_SEND == action) {
            handleActionSend(intent)
        } else if (Intent.ACTION_DIAL == action) {
            handleActionDial(intent)
        } else if (action == Intent.ACTION_VIEW) {
            val data = intent.data
            if (data?.scheme == "tel") {
                number = data.schemeSpecificPart
                mPhoneInput.setPhoneNumber(number)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_about -> startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://github.com/subhamtyagi/openinwa")))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun handleActionSend(intent: Intent) {
        val type = intent.type
        if ("text/x-vcard" == type) {
            isShare = true
            val contactUri: Uri? = intent.getParcelableExtra(Intent.EXTRA_STREAM)
            val cr: ContentResolver = contentResolver

            var data = ""
            try {
                contactUri?.let { uri ->
                    cr.openInputStream(uri)?.use { stream ->
                        data = stream.bufferedReader().use { it.readText() }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            for (line in data.lines()) {
                val trimmedLine = line.trim()
                if (trimmedLine.startsWith("TEL;CELL:")) {
                    number = trimmedLine.substring(9)
                    mPhoneInput.setPhoneNumber(number)
                }
            }
        }
    }

    private fun handleActionDial(intent: Intent) {
        number = intent.data.toString().substring(3)
        Log.d(MainActivity::class.java.name, "onStart: number==$number")
        mPhoneInput.setPhoneNumber(number)
    }

    private fun initUI() {
        mPhoneInput = findViewById(R.id.phone_input_layout)
        mBtnLink = findViewById(R.id.btn_send)
        shareMsg = findViewById(R.id.msg_text)
        shareBtn = findViewById(R.id.btn_share)
        paste = findViewById(R.id.btn_paste)
        pickBtn = findViewById(R.id.btn_pick)

        // Setup event listeners
        mBtnLink.setOnClickListener { open() }
        shareBtn.setOnClickListener { share() }
        paste.setOnClickListener { setNumberFromClipBoard() }
        pickBtn.setOnClickListener { pick() }

        // Set default country and IME options
        mPhoneInput.setDefaultCountry(Prefs(this).lastRegion)

        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        when (currentNightMode) {
            Configuration.UI_MODE_NIGHT_YES -> {
                mPhoneInput.editText.setTextColor(getResources().getColor(android.R.color.white))
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                mPhoneInput.editText.setTextColor(getResources().getColor(android.R.color.black))
            }
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                // Night mode is not defined
            }
        }
        //

        mPhoneInput.editText.imeOptions = EditorInfo.IME_ACTION_SEND
        mPhoneInput.editText.setImeActionLabel(
            getString(R.string.label_send),
            EditorInfo.IME_ACTION_SEND
        )
        mPhoneInput.editText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                open()
                true
            } else {
                false
            }
        }
    }

    private fun setNumberFromClipBoard() {
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = clipboardManager.primaryClip
        if (clipData != null && clipData.itemCount > 0) {
            number = clipData.getItemAt(0).text.toString()
            mPhoneInput.setPhoneNumber(number)
        } else {
            Toast.makeText(this, R.string.empty_clipboard, Toast.LENGTH_SHORT).show()
        }
    }



    private fun getShareMSG(): String {
        return try {
            "text=" + URLEncoder.encode(shareMsg.text.toString(), "utf-8")
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
            ""
        }
    }

    private fun hideKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun open() {
        if (setNumber()) openInWhatsapp()
    }

    private fun share() {
        if (setNumber()) shareLink(getShareMSG())
    }

    private fun pick() {
        startActivityForResult(
            Intent(Intent.ACTION_PICK).setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE),
            PICK_CONTACT
        )
    }

    private fun setNumber(): Boolean {
        hideKeyboard(mPhoneInput)
        mPhoneInput.setError(null)
        number = if (mPhoneInput.isValid) mPhoneInput.phoneNumberE164 else ""
        return if (number == "") {
            mPhoneInput.setError(getString(R.string.label_error_incorrect_phone))
            number= mPhoneInput.phoneNumberE164
            true
        } else {
            storeCountryCode()
            true
        }
    }

    private fun storeCountryCode() {
        if (mPhoneInput.isValid) {
            val phoneUtil = PhoneNumberUtil.getInstance()
            try {
                val phoneNumber = phoneUtil.parse(mPhoneInput.phoneNumberE164, "")
                Prefs(this).lastRegion = phoneUtil.getRegionCodeForNumber(phoneNumber)
            } catch (e: Exception) {
                //log.e(e, "Failed to store country code. NumberParseException thrown while trying to parse ${mPhoneInput.phoneNumberE164}")
            }
        }
    }

    private fun getNumber(): String {
        return if (number.isEmpty()) {
            ""
        } else {
            "phone=" + number.replace("^0+".toRegex(), "")
        }
    }

    private fun openInWhatsapp() {
        try {
            startActivity(Intent.parseUri("whatsapp://send/?${getNumber()}", 0))
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, R.string.label_error_whatsapp_not_installed, Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun openInTelegram() {
        try {
            startActivity(Intent.parseUri("https://t.me/$number", 0))
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "You have to install Telegram to open the chat", Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun openInSignal() {
        try {
            startActivity(Intent.parseUri("https://signal.me/#p/$number", 0))
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "You have to install Signal to open the chat", Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun shareLink(message: String) {
        val number = getNumber()
        val url =
            "https://api.whatsapp.com/send?$number${if (number.isNotEmpty() && message.isNotEmpty()) "&" else ""}$message"
        val intent = Intent(Intent.ACTION_SEND).apply {
            putExtra(Intent.EXTRA_TEXT, url)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(intent, "Send to "))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_CONTACT && resultCode == Activity.RESULT_OK) {
            val contactUri = data?.data
            val projection = arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER)
            val cursor: Cursor? = contentResolver.query(contactUri!!, projection, null, null, null)
            cursor?.use {
                if (it.moveToFirst()) {
                    val numberIndex =
                        it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                    val number = it.getString(numberIndex)
                    mPhoneInput.setPhoneNumber(number)
                }
            }
        }
    }
}
