package com.example.sathya.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sathya.myapplication.rest.ApiManager;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity implements Callback<ResponseBody> {
    ProgressDialog progressDoalog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Its loading....");
        progressDoalog.setTitle("ProgressDialog bar example");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // show it
        progressDoalog.show();
        ApiManager.getInstance().getRegions(this);


    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        try {
            if (progressDoalog.isShowing()) {
                progressDoalog.dismiss();
            }
            JSONObject jsonObject = new JSONObject(response.body().string());
            ((TextView) findViewById(R.id.txtView)).setText(jsonObject.getString("name"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        if (progressDoalog.isShowing()) {
            progressDoalog.dismiss();
        }
    }


}
