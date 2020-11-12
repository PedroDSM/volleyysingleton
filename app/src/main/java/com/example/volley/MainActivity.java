package com.example.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView Resultados;
    protected RequestQueue frequestQueue;
    private VolleyS mvolley;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mvolley=VolleyS.getInstance(this.getApplicationContext());
        frequestQueue = mvolley.getRequestQueue();
        Resultados = findViewById(R.id.resultado);
        findViewById(R.id.mostrar).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mostrar:
                String url = "https://reqres.in/api/unknown";
                JsonObjectRequest request = new JsonObjectRequest(url,null,new Response.Listener<JSONObject>(){

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject data = jsonArray.getJSONObject(i);
                                String name = data.getString("name");
                                int year = data.getInt("year");
                                Resultados.append(name + ", " + (year) + ", " + "\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
                frequestQueue.add(request);
                    }
                }
        }