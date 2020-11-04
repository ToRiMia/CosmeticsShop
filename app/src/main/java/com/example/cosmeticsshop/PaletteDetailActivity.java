package com.example.cosmeticsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PaletteDetailActivity extends AppCompatActivity {
    private TextView textViewTitle;
    private TextView textViewInfo;
    private ImageView imageViewPalette;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewInfo = findViewById(R.id.textViewInfo);
        imageViewPalette = findViewById(R.id.imageViewRevolution);
        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")) {
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId", 0);
            textViewTitle.setText(title);
            textViewInfo.setText(info);
            imageViewPalette.setImageResource(resId);
        } else {
            Intent backToCategory = new Intent(this, ShadowPaletteCategoryActivity.class);
            startActivity(backToCategory);
        }
    }
}