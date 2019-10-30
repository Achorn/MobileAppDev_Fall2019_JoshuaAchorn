package com.example.halloween_c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sayBoo(View view) {
        EditText name = findViewById(R.id.editText);
        String nameValue = name.getText().toString();


        TextView booText = findViewById(R.id.message);
        booText.setText("Happy Halloween " + nameValue + "!");

        ImageView ghost = findViewById(R.id.imageView);
        ghost.setImageResource(R.drawable.ghost);
    }

}
