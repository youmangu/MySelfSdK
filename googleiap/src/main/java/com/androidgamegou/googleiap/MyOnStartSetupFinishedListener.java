package com.androidgamegou.googleiap;

import com.android.billingclient.api.BillingClient;
import com.unity3d.player.UnityPlayer;

public class MyOnStartSetupFinishedListener implements GoogleBillingUtil.OnStartSetupFinishedListener {
    @Override
    public void onSetupSuccess() {
        //GoogleBillingUtil.getInstance().CheckPurchasesInApp();
//        UnityPlayer.UnitySendMessage("GameObject","SetupFinished","Success");

    }

    @Override
    public void onSetupFail(int responseCode) {

    }

    @Override
    public void onSetupError() {

    }
}
