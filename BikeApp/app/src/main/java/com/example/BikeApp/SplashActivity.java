package com.example.BikeApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    public static ArrayList<StationVelo> stations = new ArrayList<StationVelo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getStationVelo();

        new CountDownTimer(9000, 9000) {
            public void onFinish() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            public void onTick(long millisUntilFinished) {
            }
        }.start();
    }

    private void getStationVelo() {
        Call<Records> call = RetrofitClient.getInstance().getMyApi().getRecords();
        call.enqueue(new Callback<Records>() {
            @Override
            public void onResponse(Call<Records> call, Response<Records> response) {
                Records data = response.body();
                stations.addAll(data.getListStationVelo());
            }

            @Override
            public void onFailure(Call<Records> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"An error occured", Toast.LENGTH_SHORT).show();
            }
        });
    }
}