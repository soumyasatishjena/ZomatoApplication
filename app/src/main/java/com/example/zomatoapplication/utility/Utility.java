package com.example.zomatoapplication.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Utility {

    public static final String API_KEY = "30d981d5ef70bddf127f56239f9efd21";
    public static final String BASE_URL = "https://developers.zomato.com/api/v2.1/";
    public static long UPDATE_INTERVAL = 10 * 1000;  /* 10 secs */
    public static long FASTEST_INTERVAL = 2000; /* 2 sec */


    public static boolean isInternetAvailable(Context context) {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if(netInfo != null) {
            if (netInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                if (netInfo.isConnected()) {
                    haveConnectedWifi = true;
                }
            }
            if (netInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                if (netInfo.isConnected()) {
                    haveConnectedMobile = true;
                }
            }
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
}
