package com.androidgamegou.googleiap;

import android.app.Activity;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class GoogleBillingPay {
    private static  String TAG = "GoogleBillingPay";

    private static GoogleBillingUtil googleBillingUtil = null;
    private static Activity unity_Activity;

    public static void  Intial(Activity activity,String inAppSku, String subSku){
        //Log.d("Unity", "Intail: android intailed: " + inAppSku);

        if (inAppSku != null && !inAppSku.isEmpty())
        {
             GoogleBillingUtil.getInstance().inAppSKUS = inAppSku.split(";");
        }
        if (subSku != null && !subSku.isEmpty())
        {
            GoogleBillingUtil.getInstance().subsSKUS = subSku.split(";");
        }

        unity_Activity = activity;
        if(googleBillingUtil == null) {
            googleBillingUtil = GoogleBillingUtil.getInstance()
                    .setOnPurchaseFinishedListener(new MyOnPurchaseFinishedListener())
                    .setOnQueryFinishedListener(new MyOnQueryFinishedListener())
                    .setOnStartSetupFinishedListener(new MyOnStartSetupFinishedListener())
                    .build(activity.getApplicationContext());
        }
    }

    public static void Pay(String sku)
    {
        if(googleBillingUtil ==null) {
            UnityPlayer.UnitySendMessage("IAPListener","GooglePayResultMessgae","Nohave Intail");
            return;
        }
        // Log.d(TAG, "Pay: android Pay ;");
        googleBillingUtil.purchaseInApp(unity_Activity,sku);
    }


    public static void ConsumeInAppPurchase(String token)
    {
        googleBillingUtil.consumeAsync(token);
    }

    public static  void QueryInventoryInApp() {
        googleBillingUtil.queryInventoryInApp();
    }

    public static  void QueryPurchasesInApp() {
        googleBillingUtil.queryPurchasesInApp();
    }

    public static  void QuerySkuDetail(String sku) {
        googleBillingUtil.QuerySkuDetail(sku);
    }



}
