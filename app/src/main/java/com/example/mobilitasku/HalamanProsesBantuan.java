package com.example.mobilitasku;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HalamanProsesBantuan extends Activity {

    private LinearLayout mainLayout;
    private TextView cariSukarelawanLabel;
    private TextView animasiTitikLabel;
    private Handler handler = new Handler();
    private int dotCount = 0;
    private String tipeBantuan;
    private int animationCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Contoh tipe bantuan
        tipeBantuan = "barang"; // Ganti sesuai kebutuhan

        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        mainLayout.setGravity(Gravity.CENTER);
        mainLayout.setBackgroundColor(Color.WHITE);

        cariSukarelawanLabel = new TextView(this);
        cariSukarelawanLabel.setText("Sedang Mencari\nSukarelawan");
        cariSukarelawanLabel.setGravity(Gravity.CENTER);
        cariSukarelawanLabel.setTextSize(24);
        cariSukarelawanLabel.setTextColor(Color.BLACK);

        animasiTitikLabel = new TextView(this);
        animasiTitikLabel.setTextSize(50);
        animasiTitikLabel.setGravity(Gravity.CENTER);
        animasiTitikLabel.setTextColor(Color.BLACK);

        mainLayout.addView(cariSukarelawanLabel, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        mainLayout.addView(animasiTitikLabel, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        setContentView(mainLayout);

        startAnimation();
    }

    private void startAnimation() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                updateDots();
                animationCount++;
                if (animationCount < 10) {
                    handler.postDelayed(this, 1000);
                } else {
                    navigateToNextScreen();
                }
            }
        };
        handler.post(runnable);
    }

    private void updateDots() {
        StringBuilder dots = new StringBuilder();
        for (int i = 0; i < dotCount; i++) {
            dots.append(".");
        }
        animasiTitikLabel.setText(dots.toString());
        dotCount++;
        if (dotCount > 3) {
            dotCount = 0;
        }
    }

    private void navigateToNextScreen() {
        mainLayout.removeAllViews();

        TextView resultLabel = new TextView(this);
        resultLabel.setTextSize(24);
        resultLabel.setGravity(Gravity.CENTER);

        if ("barang".equalsIgnoreCase(tipeBantuan)) {
            resultLabel.setText("Proses Bantuan Barang");
            mainLayout.setBackgroundColor(Color.LTGRAY);
        } else if ("transportasi".equalsIgnoreCase(tipeBantuan)) {
            resultLabel.setText("Proses Bantuan Transportasi");
            mainLayout.setBackgroundColor(Color.ORANGE);
        }

        mainLayout.addView(resultLabel, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
    }

    public static void launch(Context context, String tipeBantuan) {
        Intent intent = new Intent(context, HalamanProsesBantuan.class);
        intent.putExtra("tipeBantuan", tipeBantuan);
        context.startActivity(intent);
    }
}
