package com.example.theupdatedbouldercoffeerec;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class CoffeeActivity extends AppCompatActivity{
    private String coffeeShop;
    private String coffeeShopURL;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebSite(view);
            }
        });

        Intent intent = getIntent();
        coffeeShop = intent.getStringExtra("coffeeShopName");
        coffeeShopURL = intent.getStringExtra("coffeeShopURL");
        Log.i("shop received", coffeeShop);
        Log.i("url received", coffeeShopURL);

        //update text view
        TextView messageView = findViewById(R.id.coffeeShopTextView);
        messageView.setText("You should check out " + coffeeShop);


    }
    private void loadWebSite(View view){
        Intent intent = new Intent((Intent.ACTION_VIEW));
        intent.setData(Uri.parse(coffeeShopURL));
        startActivity(intent);
    }
}
