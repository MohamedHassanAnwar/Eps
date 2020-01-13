package com.example.eps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class AnotherActivity extends AppCompatActivity {
    TextView mTitleTv, mDesTv;
    CircleImageView mimageIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        mTitleTv = findViewById(R.id.title);
        mDesTv = findViewById(R.id.description);
        mimageIv = findViewById(R.id.imageView);

        //now get our data from intent in which we put our data

        Intent intent = getIntent();

        String mTitle = intent.getStringExtra("iTitle");
        String mDescription = intent.getStringExtra("iDesc");

        byte[] mBytes = getIntent().getByteArrayExtra("iImage");

        //now decode image because from previous activity we get our image in bytes
        Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes, 0 , mBytes.length);

        //now set our data in our view, which we get in our previous activity
        mTitleTv.setText(mTitle);
        mDesTv.setText(mDescription);
        mimageIv.setImageBitmap(bitmap);
    }
}
