package com.example.mobilitasku;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Membuat LinearLayout sebagai root container
        LinearLayout rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        rootLayout.setGravity(Gravity.CENTER);
        rootLayout.setBackgroundColor(Color.WHITE);
        rootLayout.setPadding(16, 16, 16, 16);

        // Membuat TextView untuk selamat datang
        TextView welcomeText = new TextView(this);
        welcomeText.setText("Selamat Datang di Mobilitasku");
        welcomeText.setTextSize(24);
        welcomeText.setTextColor(Color.BLACK);
        welcomeText.setGravity(Gravity.CENTER);
        welcomeText.setPadding(0, 0, 0, 32);
        rootLayout.addView(welcomeText); // Tambahkan ke root layout

        // Membuat Button untuk minta bantuan
        Button bantuanButton = new Button(this);
        bantuanButton.setText("Minta Bantuan");
        bantuanButton.setTextSize(16);
        bantuanButton.setPadding(16, 16, 16, 16);
        bantuanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke halaman bantuan
                Intent intent = new Intent(MainActivity.this, HalamanMintaBantuan.class);
                startActivity(intent);
            }
        });
        rootLayout.addView(bantuanButton); // Tambahkan ke root layout

        // Atur root layout sebagai tampilan utama
        setContentView(rootLayout);
    }
}
