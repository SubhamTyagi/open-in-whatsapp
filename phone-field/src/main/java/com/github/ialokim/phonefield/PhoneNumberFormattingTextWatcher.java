/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.ialokim.phonefield;

import com.google.i18n.phonenumbers.AsYouTypeFormatter;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;

import java.util.Locale;

/**
 * Watches a {@link android.widget.TextView} and if a phone number is entered
 * will format it.
 * <p>
 * Stop formatting when the user
 * <ul>
 * <li>Inputs non-dialable characters</li>
 * <li>Removes the separator in the middle of string.</li>
 * </ul>
 * <p>
 * The formatting will be restarted once the text is cleared.
 *
 * This class is ported from the AOSP source code with slight modifications:
 * <ul>
 *     <li>added method setCountry(String countryCode) to switch the formatting Locale after constructing</li>
 *     <li>added field mRawPhoneNumber and method getRawPhoneNumber() to keep track of the unformatted number</li>
 *     <li>enhanced logic when to stop formatting (not when deleting the entire string)</li>
 * </ul>
 */
public class PhoneNumberFormattingTextWatcher implements TextWatcher {

    /**
     * Indicates the change was caused by ourselves.
     */
    boolean mSelfChange = false;

    /**
     * Indicates the formatting has been stopped.
     */
    private boolean mStopFormatting;

    /**
     * Indicated the change should be ignored
     */
    boolean mIgnore;

    private AsYouTypeFormatter mFormatter;

    private String mRawPhoneNumber = "";

    /**
     * The formatting is based on the current system locale and future locale changes
     * may not take effect on this instance.
     */
    PhoneNumberFormattingTextWatcher() {
        this(Locale.getDefault().getCountry());
    }

    /**
     * The formatting is based on the given <code>countryCode</code>.
     *
     * @param countryCode the ISO 3166-1 two-letter country code that indicates the country/region
     * where the phone number is being entered.
     */
    PhoneNumberFormattingTextWatcher(String countryCode) {
        if (countryCode == null) throw new IllegalArgumentException();
        mFormatter = PhoneNumberUtil.getInstance().getAsYouTypeFormatter(countryCode);
    }

    /**
     * Set the formatting based on the given <code>countryCode</code>.
     *
     * @param countryCode the ISO 3166-1 two-letter country code that indicates the country/region
     * where the phone number is being entered.
     */
    void setCountry(String countryCode) {
        if (countryCode == null) throw new IllegalArgumentException();
        mFormatter = PhoneNumberUtil.getInstance().getAsYouTypeFormatter(countryCode.toUpperCase());
    }

    /**
     * Get the unformatted phone number, which is being updated while formatting
     * or {@code null} if the formatting got stuck
     *
     * @return the raw phone number without separators
     */
    String getRawPhoneNumber() {
        return mStopFormatting ? null : mRawPhoneNumber;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
        if (mSelfChange || mStopFormatting || mIgnore) {
            return;
        }
        // If the user manually deleted any non-dialable characters, stop formatting
        // except when he deletes all the characters
        if (count > 0 && hasSeparator(s, start, count) && count != s.length()) {
            stopFormatting();
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (mSelfChange || mStopFormatting || mIgnore) {
            return;
        }
        // If the user inserted any non-dialable characters, stop formatting
        // except when he is inserting all the characters
        if (count > 0 && hasSeparator(s, start, count) && before != 0) {
            stopFormatting();
        }
    }

    @Override
    public synchronized void afterTextChanged(Editable s) {
        if (mStopFormatting) {
            // Restart the formatting when all texts were clear.
            mStopFormatting = !(s.length() == 0);
            return;
        }
        if (mSelfChange || mIgnore) {
            // Ignore the change caused by s.replace().
            return;
        }
        String formatted = reformat(s, Selection.getSelectionEnd(s));
        if (formatted != null) {
            int rememberedPos = mFormatter.getRememberedPosition();
            mSelfChange = true;
            s.replace(0, s.length(), formatted, 0, formatted.length());
            // The text could be changed by other TextWatcher after we changed it. If we found the
            // text is not the one we were expecting, just give up calling setSelection().
            if (formatted.equals(s.toString())) {
                Selection.setSelection(s, rememberedPos);
            }
            mSelfChange = false;
        }
    }

    /**
     * Generate the formatted number by ignoring all non-dialable chars and stick the cursor to the
     * nearest dialable char to the left. For instance, if the number is  (650) 123-45678 and '4' is
     * removed then the cursor should be behind '3' instead of '-'.
     */
    private String reformat(CharSequence s, int cursor) {
        // The index of char to the leftward of the cursor.
        int curIndex = cursor - 1;
        String formatted = null;
        mFormatter.clear();
        mRawPhoneNumber = "";
        char lastNonSeparator = 0;
        boolean hasCursor = false;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (PhoneNumberUtils.isNonSeparator(c)) {
                if (lastNonSeparator != 0) {
                    formatted = getFormattedNumber(lastNonSeparator, hasCursor);
                    hasCursor = false;
                }
                lastNonSeparator = c;
                mRawPhoneNumber += c;
            }
            if (i == curIndex) {
                hasCursor = true;
            }
        }
        if (lastNonSeparator != 0) {
            formatted = getFormattedNumber(lastNonSeparator, hasCursor);
        }
        return formatted;
    }

    private String getFormattedNumber(char lastNonSeparator, boolean hasCursor) {
        return hasCursor ? mFormatter.inputDigitAndRememberPosition(lastNonSeparator)
                : mFormatter.inputDigit(lastNonSeparator);
    }

    private void stopFormatting() {
        mStopFormatting = true;
        mFormatter.clear();
    }

    private boolean hasSeparator(final CharSequence s, final int start, final int count) {
        for (int i = start; i < start + count; i++) {
            char c = s.charAt(i);
            if (!PhoneNumberUtils.isNonSeparator(c)) {
                return true;
            }
        }
        return false;
    }
}