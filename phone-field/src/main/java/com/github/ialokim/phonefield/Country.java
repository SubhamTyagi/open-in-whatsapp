package com.github.ialokim.phonefield;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Country object that holds the country iso2 code, dial code, a list of known area codes and it's priority.
 */
public class Country {

    private final String mCode;

    private final int mDialCode;

    private final List<String> mAreaCodes;
    private final int mAreaCodeLength;

    private final boolean mPriority;

    public Country(String code, int dialCode, boolean priority) {
        this(code, dialCode, priority, new ArrayList<String>());
    }
    public Country(String code, int dialCode, boolean priority, List<String> areaCodes) {
        mCode = code;
        mDialCode = dialCode;
        mAreaCodes = areaCodes;
        if (areaCodes.size() == 0)
            mAreaCodeLength = 0;
        else
            mAreaCodeLength = mAreaCodes.get(0).length();
        mPriority = priority;
    }

    public String getCode() {
        return mCode;
    }

    public String getDialCode() {
        return getDialCode(false);
    }

    public String getDialCode(boolean formatted) {
        if (formatted) {
            String code = "+" + mDialCode;
            if (mAreaCodes.size() == 1)
                code += " " + mAreaCodes.get(0);
            return code;
        }
        return String.valueOf(mDialCode);
    }

    public boolean containsNumber(long number) {
        String national = String.valueOf(number);
        if (mAreaCodeLength > 0 && national.length() >= mAreaCodeLength) {
            String areaCode = national.substring(0,mAreaCodeLength);
            return mAreaCodes.contains(areaCode);
        }

        return mPriority;
    }

    public String getDisplayName() {
        return new Locale("", mCode).getDisplayCountry();
    }

    public int getResId(Context context) {
        String name = String.format("country_flag_%s", mCode.toLowerCase());
        final Resources resources = context.getResources();
        return resources.getIdentifier(name, "drawable", context.getPackageName());
    }
}
