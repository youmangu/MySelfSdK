package com.androidgamegou.googleiap;

import android.os.Debug;
import android.util.Log;

import com.android.billingclient.api.Purchase;
import com.unity3d.player.UnityPlayer;

import java.util.List;

public class MyOnPurchaseFinishedListener implements GoogleBillingUtil.OnPurchaseFinishedListener
{
    @Override
    public void onPurchaseSuccess(List<Purchase> list) {
        //Log.d("Unity", "=================== onPurchaseSuccess");
        UnityPlayer.UnitySendMessage("IAPListener","GooglePayResultMessgae","Success;"+list.get(0).getSku()
                +";"+list.get(0).getSignature()+";" +list.get(0).getOriginalJson()+";"+ list.get(0).getPurchaseToken()) ;
    }

    @Override
    public void onPurchaseFail(int responseCode) {
        //Log.d("Unity", "=================== onPurchaseFail : " + responseCode);
        UnityPlayer.UnitySendMessage("IAPListener","GooglePayResultMessgae","Failed;"+String.valueOf(responseCode));
    }

    @Override
    public void onPurchaseError() {
        //Log.d("Unity", "=================== onPurchaseError" );
        UnityPlayer.UnitySendMessage("IAPListener","GooglePayResultMessgae","Error");
    }

}
