package com.example.cosmeticsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShadowPaletteCategoryActivity extends AppCompatActivity {

    private ListView listViewPalette;

    private ArrayList<Palette> palettes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow_palette_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        palettes = new ArrayList<>();
        palettes.add(new Palette(getString(R.string.palette1_title), getString(R.string.palette1_info), R.drawable.palette_revolution));
        palettes.add(new Palette(getString(R.string.palette2_title), getString(R.string.palette2_info), R.drawable.palette_ruby_rose));
        palettes.add(new Palette(getString(R.string.palette3_title), getString(R.string.palette3_info), R.drawable.palette_nyx));
        listViewPalette = findViewById(R.id.listViewPalette);
        ArrayAdapter<Palette> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, palettes);
        listViewPalette.setAdapter(adapter);
        listViewPalette.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Palette palette = palettes.get(position);
                Intent intent = new Intent(getApplicationContext(), PaletteDetailActivity.class);
                intent.putExtra("title", palette.getTitle());
                intent.putExtra("info", palette.getInfo());
                intent.putExtra("resId", palette.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}