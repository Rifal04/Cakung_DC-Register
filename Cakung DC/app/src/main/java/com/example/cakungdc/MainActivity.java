package com.example.cakungdc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Membuat Variabel
   private EditText userName, pass;
    private Button btn_masuk;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Singkronisasi Dengan Vsriabel Layout
        btn_masuk = findViewById(R.id.btn_msk);
        userName = findViewById(R.id.edit_email);
        pass = findViewById(R.id.edit_psw);

        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Konfirmasi Data Harus Lengkap

                //data harus diisi
                if (!userName.getText().toString().equals("") && !pass.getText().toString().equals("")
                        && pass.getText().toString().length() > 6) {
                    //jika data diisi (menampilkan toast)
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, RegistActivity.class);
                    intent.putExtra("email", userName.getText().toString());
                    intent.putExtra("psw", userName.getText().toString());
                    startActivity(intent);
                    finish();

                }
                //jika password diisi kurang dari 6 karakter
                else if (pass.getText().toString().length() < 6 && pass.getText().toString().length() > 0) {
                    Toast.makeText(MainActivity.this, "Password Kurang 6 Karakter", Toast.LENGTH_SHORT).show();
                }
                //jika data tidak diisi
                else {
                    Toast.makeText(MainActivity.this, "Email Harus Lengkap", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
