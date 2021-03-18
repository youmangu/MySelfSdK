package com.androidgamegou.googleiap;
import android.util.Log;

import com.android.billingclient.api.SkuDetails;
import com.unity3d.player.UnityPlayer;

import java.util.List;

public class MyOnQueryFinishedListener implements GoogleBillingUtil.OnQueryFinishedListener {
    @Override
    public void onQuerySuccess(String skuType, List<SkuDetails> list) {
        //UnityPlayer.UnitySendMessage("GameObject","GooglePayResultMessgae","skutype:"+skuType+);
//        String inAppInfo = "Successed;";
//        for (SkuDetails info: list) {
//            inAppInfo += info.getSku()+";";
//        }
//        UnityPlayer.UnitySendMessage("GameObject","GetSkuDetails",inAppInfo);
        String sku_details = "Successed;";
        for (int i = 0 ; i < list.size(); i++){
            sku_details += list.get(i).getSku()+",";
            sku_details += list.get(i).getPrice()+";";
//            Log.d("Unity","================================ OnQuery ");
//            Log.d("Unity","price: " + list.get(i).getPrice());
//            Log.d("Unity","getPriceCurrencyCode: " + list.get(i).getPriceCurrencyCode());
//            Log.d("Unity","getPriceAmountMicros: " + list.get(i).getPriceAmountMicros());
//            Log.d("Unity","getDescription: " + list.get(i).getDescription());
//            Log.d("Unity","getIntroductoryPriceAmountMicros: " + list.get(i).getIntroductoryPriceAmountMicros());
//            Log.d("Unity","getIntroductoryPrice: " + list.get(i).getIntroductoryPrice());
//            Log.d("Unity","getIntroductoryPriceCycles: " + list.get(i).getIntroductoryPriceCycles());
//            Log.d("Unity","getIntroductoryPricePeriod: " + list.get(i).getIntroductoryPricePeriod());
//            Log.d("Unity","================================ OnQuery  end");
            if(GoogleBillingUtil.skuDetailsMap.get(list.get(i).getSku()) == null) {
                GoogleBillingUtil.skuDetailsMap.put(list.get(i).getSku(), list.get(i));
            }
        }
        //Log.d("GoogleBillingPay", "onQuerySuccess ; " + sku_details);
        UnityPlayer.UnitySendMessage("IAPListener","GetSkuDetails",sku_details);
    }

    @Override
    public void onQueryFail(int responseCode) {
        //Log.d("GoogleBillingPay", "onQueryFail ; " + String.valueOf(responseCode));
        UnityPlayer.UnitySendMessage("IAPListener","GetSkuDetails","Failed;"+String.valueOf(responseCode));
    }

    @Override
    public void onQueryError() {
        //Log.d("GoogleBillingPay", "onQueryError ; ");
        UnityPlayer.UnitySendMessage("IAPListener","GetSkuDetails","Error");
    }
}