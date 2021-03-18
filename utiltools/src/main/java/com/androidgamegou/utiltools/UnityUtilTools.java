package com.androidgamegou.utiltools;

import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;
import android.util.Log;

import static android.content.Context.VIBRATOR_SERVICE;

public class UnityUtilTools {
    private  final static int baseVibrate = 10;
    public static void Vibrate(Activity context, float duration, float volume)
    {
        if(context == null || duration <= 0 || volume <= 0 )
            return;

        Vibrator vibrator = (Vibrator) context.getSystemService(VIBRATOR_SERVICE);
        long milliseconds = (long)(duration * 1000);
        if(volume >= 1)
        {
            long [] arr = new long[]{0, milliseconds};
            vibrator.vibrate(arr, -1);
            return;
        }

        long vibrateMS = (long)(milliseconds * volume);
        long totalLength = milliseconds / baseVibrate;
        long vibrateLength = vibrateMS / baseVibrate;
        long offLength = totalLength - vibrateLength;

        int interval = 0;
        int fillData = 0;
        boolean isVibrateLong = vibrateLength > offLength;
        if(isVibrateLong) {
            interval = (int) (vibrateLength / offLength);
            vibrateLength = vibrateLength / interval;
        }
        else {
            interval = (int) (offLength / vibrateLength);
            offLength = offLength / interval;
        }

        fillData = interval * baseVibrate;
        totalLength = isVibrateLong ? vibrateLength + offLength + 1 : vibrateLength + offLength;
        long [] pattern = new long[(int)totalLength];
        for(int i = 0; i < totalLength; i++)
        {
            if(isVibrateLong ? i%2 == 1 : i%2 == 0)
                pattern[i] = fillData;
            else
                pattern[i] = baseVibrate;
        }

        vibrator.vibrate(pattern, -1);
    }

    public static void SetSharedPreferenceValue(Activity context,String key,  String value)
    {
        String fileName = context.getPackageName() + ".token";
        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(context, fileName);
        if (!value.equals("")){
            sharedPreferencesHelper.save(key, value);
        }
    }

    public static String GetSharedPreferenceValue(Activity context,String key)
    {
        String fileName = context.getPackageName() + ".token";
        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(context, fileName);
        String value = "";
        if(sharedPreferencesHelper.contain(key))
            value = sharedPreferencesHelper.getSharedPreference(key, "").toString().trim();
        else
            Log.i("UnityTools", "the key " + key + " is not contain");

        return value;
    }

    public static void ClearSharedPreferenceValue(Activity context)
    {
        String fileName = context.getPackageName() + ".token";
        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(context, fileName);
        sharedPreferencesHelper.clear();
    }


}
