package com.example.android.ahmadbahri_1202150111_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("AsyncTask"); //set title menjadi AsyncTask
    }

    public void mahasiswa(View view) {

        //ketika button di klik, maka akan berpindah ke ListMahasiswa class
        Intent a = new Intent(this, ListMahasiswa.class);
        startActivity(a);


    }

    public void gambar(View view) {
        //ketika button di klik, maka akan berpindah ke CariGambar class
        Intent b = new Intent(this, CariGambar.class);
        startActivity(b);
    }
}
