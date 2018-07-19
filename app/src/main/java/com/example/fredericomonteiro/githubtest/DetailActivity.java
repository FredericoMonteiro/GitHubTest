package com.example.fredericomonteiro.githubtest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;

import retrofit2.http.Url;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        GitHubUserProfile userInfo = (GitHubUserProfile)intent.getSerializableExtra("user info");

        TextView vName = findViewById(R.id.tv_name);
        vName.setText(userInfo.getName());
        TextView vEmail = findViewById(R.id.tv_email);
        vEmail.setText(userInfo.getEmail());

        ImageView avatar = findViewById(R.id.imageView);



        new DownloadImageTask(avatar).execute(userInfo.getAvatar_url());



    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap image = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                image = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return image;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}
