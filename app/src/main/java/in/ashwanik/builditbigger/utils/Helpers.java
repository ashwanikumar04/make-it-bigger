package in.ashwanik.builditbigger.utils;

import android.text.TextUtils;
import android.view.View;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import in.ashwanik.builditbigger.common.BaseApplication;


/**
 * Created by AshwaniK on 2/28/2016.
 */
public class Helpers {

    public static double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.#");
        return Double.valueOf(twoDForm.format(d));
    }

    public static <T> boolean isEmpty(Collection<T> list) {
        return list == null || list.size() == 0;
    }

    public static <T> boolean isNotEmpty(Collection<T> list) {
        return list != null && list.size() > 0;
    }

    public static void saveStringAsPreference(String prefFileName, String key, String value) {
        SharedPreference.saveStringAsPreference(BaseApplication.getInstance(), prefFileName, key, value);
    }


    public static String getStringAsPreference(String prefFileName, String key, String defaultValue) {
        return SharedPreference.getStringAsPreference(BaseApplication.getInstance(), prefFileName, key, defaultValue);
    }

    public static void saveIntegerAsPreference(String prefFileName, String key, int value) {
        SharedPreference.saveIntegerAsPreference(BaseApplication.getInstance(), prefFileName, key, value);
    }

    public static int getIntegerAsPreference(String prefFileName, String key, int defaultValue) {
        return SharedPreference.getIntegerAsPreference(BaseApplication.getInstance(), prefFileName, key, defaultValue);
    }


}
