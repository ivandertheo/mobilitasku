package com.example.mobilitasku;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HalamanMintaBantuan extends AppCompatActivity {

    private LinearLayout mainLayout;
    private LinearLayout bantuanBarangLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_minta_bantuan);

        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setGravity(Gravity.CENTER);
        setContentView(mainLayout);

        // Teks Judul
        TextView labelMintaBantuan = new TextView(this);
        labelMintaBantuan.setText("PILIH JENIS BANTUAN");
        labelMintaBantuan.setTextSize(24);
        labelMintaBantuan.setGravity(Gravity.CENTER);
        mainLayout.addView(labelMintaBantuan);

        // Tombol Bantuan Barang
        Button bantuanBarangButton = new Button(this);
        bantuanBarangButton.setText("Bantuan Barang");
        bantuanBarangButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToBantuanBarangPanel();
            }
        });
        mainLayout.addView(bantuanBarangButton);

        // Tombol Bantuan Transportasi
        Button bantuanTransportasiButton = new Button(this);
        bantuanTransportasiButton.setText("Bantuan Transportasi");
        bantuanTransportasiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HalamanMintaBantuan.this, "Halaman Bantuan Transportasi belum tersedia.", Toast.LENGTH_SHORT).show();
            }
        });
        mainLayout.addView(bantuanTransportasiButton);

        // Layout untuk halaman bantuan barang
        bantuanBarangLayout = new LinearLayout(this);
        bantuanBarangLayout.setOrientation(LinearLayout.VERTICAL);
        bantuanBarangLayout.setGravity(Gravity.CENTER);
        bantuanBarangLayout.setVisibility(View.GONE);  // Sembunyikan awalnya

        TextView titleLabel = new TextView(this);
        titleLabel.setText("Halaman Bantuan Barang");
        titleLabel.setTextSize(24);
        titleLabel.setGravity(Gravity.CENTER);
        bantuanBarangLayout.addView(titleLabel);

        // Field Deskripsi Barang
        TextView barangLabel = new TextView(this);
        barangLabel.setText("Deskripsi Barang:");
        bantuanBarangLayout.addView(barangLabel);

        EditText barangField = new EditText(this);
        bantuanBarangLayout.addView(barangField);

        // Field Lokasi
        TextView lokasiLabel = new TextView(this);
        lokasiLabel.setText("Lokasi Kamu:");
        bantuanBarangLayout.addView(lokasiLabel);

        EditText lokasiField = new EditText(this);
        bantuanBarangLayout.addView(lokasiField);

        // Field Ongkos
        TextView ongkosLabel = new TextView(this);
        ongkosLabel.setText("Ongkos:");
        bantuanBarangLayout.addView(ongkosLabel);

        EditText ongkosField = new EditText(this);
        bantuanBarangLayout.addView(ongkosField);

        // Spinner Prioritas
        TextView prioritasLabel = new TextView(this);
        prioritasLabel.setText("Pilih Prioritas:");
        bantuanBarangLayout.addView(prioritasLabel);

        Spinner prioritasSpinner = new Spinner(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{"Reguler", "Express"});
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prioritasSpinner.setAdapter(adapter);
        bantuanBarangLayout.addView(prioritasSpinner);

        // Tombol Kirim
        Button kirimButton = new Button(this);
        kirimButton.setText("Kirim");
        kirimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String barang = barangField.getText().toString();
                String lokasi = lokasiField.getText().toString();
                String ongkos = ongkosField.getText().toString();
                String prioritas = prioritasSpinner.getSelectedItem().toString();

                if (barang.isEmpty() || lokasi.isEmpty() || ongkos.isEmpty()) {
                    Toast.makeText(HalamanMintaBantuan.this, "Mohon Lengkapi semua data!", Toast.LENGTH_SHORT).show();
                } else {
                    String message = "Deskripsi Barang: " + barang + "\n" +
                            "Lokasi: " + lokasi + "\n" +
                            "Ongkos: " + ongkos + "\n" +
                            "Prioritas: " + prioritas;

                    Toast.makeText(HalamanMintaBantuan.this, "Data berhasil dikirim:\n" + message, Toast.LENGTH_LONG).show();
                    // Lakukan penyimpanan data atau navigasi ke halaman proses bantuan barang
                    Intent intent = new Intent(HalamanMintaBantuan.this, HalamanProsesBantuanBarang.class);
                    startActivity(intent);
                }
            }
        });
        bantuanBarangLayout.addView(kirimButton);

        // Tombol Kembali
        Button backButton = new Button(this);
        backButton.setText("Kembali");
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToMainPanel();
            }
        });
        bantuanBarangLayout.addView(backButton);

        // Tambahkan layout bantuan barang
        mainLayout.addView(bantuanBarangLayout);
    }

    private void switchToBantuanBarangPanel() {
        mainLayout.setVisibility(View.GONE);
        bantuanBarangLayout.setVisibility(View.VISIBLE);
    }

    private void switchToMainPanel() {
        bantuanBarangLayout.setVisibility(View.GONE);
        mainLayout.setVisibility(View.VISIBLE);
    }
}
