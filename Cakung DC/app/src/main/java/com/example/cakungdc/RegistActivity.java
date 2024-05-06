package com.example.cakungdc;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegistActivity extends AppCompatActivity {

    //Membuat Variabel
    private EditText edit_date, nama, kota;
    private RadioButton jenis_kelamin1, jenis_kelamin2;
    private Button btn_smb;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat simpleDateFormat;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        // Singkronisasi Dengan Vsriabel Layout
        nama = findViewById(R.id.edit_name);
        kota = findViewById(R.id.edit_domisili);
        jenis_kelamin1 = findViewById(R.id.gnd_lk);
        jenis_kelamin2 = findViewById(R.id.gnd_prm);
        edit_date = findViewById(R.id.edit_bd);
        btn_smb = findViewById(R.id.btn_smb);

        btn_smb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nama.getText().toString().equals("") && !kota.getText().toString().equals("")
                        && !edit_date.getText().toString().equals("")) {
                    if (jenis_kelamin1.isChecked() || jenis_kelamin2.isChecked()) {
                        String user =nama.getText().toString();

                        Toast.makeText(RegistActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegistActivity.this, DataActivity.class);
                        intent.putExtra("nama", user);
                        intent.putExtra("domisili", kota.getText().toString());
                        if (jenis_kelamin1.isChecked()) {
                            intent.putExtra("lk", jenis_kelamin1.getText().toString());
                        } else {
                            intent.putExtra("pr", jenis_kelamin2.getText().toString());
                        }
                        intent.putExtra("date", edit_date.getText().toString().toUpperCase());
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Toast.makeText(RegistActivity.this, "Data Harus Lengkap", Toast.LENGTH_SHORT).show();
                }
            }
        });

        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        edit_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDate();
            }

            private void showDate() {
                Calendar calender = Calendar.getInstance();

                datePickerDialog = new DatePickerDialog(RegistActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, month, dayOfMonth);

                        edit_date.setText(simpleDateFormat.format(newDate.getTime()));
                    }
                },calender.get(Calendar.YEAR), calender.get(Calendar.MONTH), calender.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
    }
}
