package com.example.android.ahmadbahri_1202150111_studycase4;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class CariGambar extends AppCompatActivity {

    private EditText mGambar;
    private ImageView gmbr;
    private Button button_cari;
    private ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_gambar);

        // Memanggil variable yang sudah di inisiasi
        mGambar = (EditText) findViewById(R.id.gambar);
        gmbr = (ImageView) findViewById(R.id.hasilGambar);
        button_cari = (Button) findViewById(R.id.cari);

    }

    public void cari(View view)  {
        loadImageInit();
    }

    private void loadImageInit(){
        String ImgUrl = mGambar.getText().toString();
        //AsyncTask untuk mencari gambar di internet
        new loadImage().execute(ImgUrl);
    }
    private class loadImage extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // Membuat Progress Dialog
            mProgressDialog = new ProgressDialog(CariGambar.this);

            // setting pada progress dialog
            mProgressDialog.setMessage("Loading...");

            // menampilkan Progress Dialog
            mProgressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;
            try {
                // mendownload gambar dari url
                URL url = new URL(params[0]);
                // mengkonversikan gambar ke bitmap
                bitmap = BitmapFactory.decodeStream((InputStream)url.getContent());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            //mengembalikan nilai bitmap
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            // menampung gambar ke imageView dan menampilkannya
            gmbr.setImageBitmap(bitmap);

            // menghilangkan Progress Dialog
            mProgressDialog.dismiss();
        }
    }
}


