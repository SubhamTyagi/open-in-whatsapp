package com.github.ialokim.phonefield;

import android.content.Context;
import com.google.android.material.textfield.TextInputLayout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;

import io.github.subhamtyagi.phone.R;

/**
 * Implementation of PhoneField that uses {@link TextInputLayout}
 * Created by Ismail on 5/6/16.
 * Adapted by ialokim in 2019.
 */
public class PhoneInputLayout extends PhoneField {

    private TextInputLayout mTextInputLayout;

    public PhoneInputLayout(Context context) {
        this(context, null);
    }

    public PhoneInputLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PhoneInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void updateLayoutAttributes() {
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        setGravity(Gravity.TOP);
        setOrientation(HORIZONTAL);
    }

    @Override
    protected void prepareView() {
        super.prepareView();
        mTextInputLayout = (TextInputLayout) findViewWithTag(getResources().getString(R.string.phonefield_til_phone));
    }

    @Override
    public int getLayoutResId() {
        return R.layout.phone_text_input_layout;
    }

    @Override
    public void setHint(int resId) {
        mTextInputLayout.setHint(getContext().getString(resId));
    }

    @Override
    public void setError(String error) {
        if (error == null || error.length() == 0) {
            mTextInputLayout.setErrorEnabled(false);
        } else {
            mTextInputLayout.setErrorEnabled(true);
        }
        mTextInputLayout.setError(error);
    }

    public TextInputLayout getTextInputLayout() {
        return mTextInputLayout;
    }
}
