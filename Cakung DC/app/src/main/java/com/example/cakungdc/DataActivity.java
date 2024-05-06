package com.example.cakungdc;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {
    private TextView email, nama, ulang_tahun, domisili, jenis_kelamin1, jenis_kelamin2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datafinaly);

        email = findViewById(R.id.data_email);
        nama = findViewById(R.id.data_nama);
        ulang_tahun = findViewById(R.id.data_ulangTahun);
        domisili = findViewById(R.id.data_domisili);
        jenis_kelamin1 = findViewById(R.id.data_jenisKelamin1);
        jenis_kelamin2 = findViewById(R.id.data_jenisKelamin2);

        email.setText(getIntent().getStringExtra("email"));
        nama.setText(getIntent().getStringExtra("nama"));
        ulang_tahun.setText(getIntent().getStringExtra("date"));
        domisili.setText(getIntent().getStringExtra("domisili"));
        jenis_kelamin1.setText(getIntent().getStringExtra("lk"));
        jenis_kelamin2.setText(getIntent().getStringExtra("pr"));

    }
}