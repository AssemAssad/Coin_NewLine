package com.example.coin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewsDetails extends AppCompatActivity {

    TextView tv_title_news,tv_time_news,tv_big_text;
    ImageView iv_news;
    Button btn_share_facebook,btn_share_twitter , btn_share_all,btn_back;
    ImageButton btn_share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_news);

        tv_title_news = findViewById(R.id.tv_title_news);
        tv_time_news = findViewById(R.id.tv_time_news);
        tv_big_text = findViewById(R.id.tv_big_text);
        iv_news = findViewById(R.id.iv_news);
        btn_share_facebook = findViewById(R.id.btn_share_facebook);
        btn_share_twitter = findViewById(R.id.btn_share_twitter);
        btn_share = findViewById(R.id.btn_share);
        btn_share_all = findViewById(R.id.btn_share_all);
        btn_back = findViewById(R.id.btn_back);


        String title = getIntent().getStringExtra("title");
        String time = getIntent().getStringExtra("time");
        String text = getIntent().getStringExtra("text");
        int img = getIntent().getIntExtra("img",R.drawable.bitmap);


        tv_title_news.setText(title);
        tv_time_news.setText(time);
        tv_big_text.setText(text);
        iv_news.setImageResource(img);


        btn_share_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, text);
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, text);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

        btn_share_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Uri uri = Uri
//                        .parse("android.resource://com.example.coinz_xml/drawable/"+img);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, text);
                intent.setType("text/plain");
//                intent.putExtra(Intent.EXTRA_STREAM, uri);
//                intent.setType("image/jpeg");
                intent.setPackage("com.twitter.android");
                startActivity(intent);
            }
        });

        btn_share_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, text);
                intent.setType("text/plain");
                intent.setPackage("com.facebook.katana");
                startActivity(intent);
            }
        });

    }
}