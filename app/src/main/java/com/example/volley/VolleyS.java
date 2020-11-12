package com.example.volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyS {

    private static VolleyS mVolleys = null;

    private RequestQueue requestQueue;

    private VolleyS(Context context){

        requestQueue= Volley.newRequestQueue(context);
    }

    public static VolleyS getInstance(Context context){
        if(mVolleys==null){
            mVolleys = new VolleyS(context);
        }
        return mVolleys;
    }
    public RequestQueue getRequestQueue(){
        return  requestQueue;
    }
}
