package com.example.counters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtSayac;
    //private CountDownTimer counter;
    private Runnable runnable;
    private Handler handler;
    private int sayac = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSayac = (TextView)findViewById(R.id.textViewSayac);
    }

    public void btnSayaciBaslat(View v){
        sayac = 0;
        // 1000 rakam = 1 saniye

        // Geriye Doğru Sayan Sayaç
        /*new CountDownTimer(10100, 1000) {
            @Override
            public void onTick(long l) {
                txtSayac.setText("Kalan: " + (l/1000));
            }

            @Override
            public void onFinish() {

            }
        }.start();*/

        /*counter = new CountDownTimer(5100, 1000) {
            @Override
            public void onTick(long l) {
                txtSayac.setText("Kalan: " + (l/1000));
            }

            @Override
            public void onFinish() {

            }
        };
        counter.start();*/

        //İleri Doğru Sayan Sayaç:
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                txtSayac.setText("Sayım: " +sayac);
                sayac++;
                handler.postDelayed(runnable, 1000);
            }
        };
        handler.post(runnable);
    }
}