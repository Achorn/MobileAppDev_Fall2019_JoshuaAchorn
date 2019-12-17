package com.example.mobileappfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Button buildBurrito;
    private TextView response;
    private EditText nameText;
    private ToggleButton toggleType;
    private Switch casing;
    private Button burBut;
    private Button taBut;
    private RadioGroup group;


    private CheckBox sour;
    private CheckBox guac;
    private CheckBox cheese;
    private CheckBox salsa;

    private Spinner places;

//    part 2


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        buildBurrito = findViewById(R.id.button);
        response = findViewById(R.id.textView);
        nameText = findViewById(R.id.name);

        toggleType = findViewById(R.id.toggleButton);
        casing = findViewById(R.id.switch1);
        burBut = findViewById(R.id.bButton);
        taBut = findViewById(R.id.tButton);
        group = findViewById(R.id.radioGroup3);

        cheese = findViewById(R.id.chButton);
        sour = findViewById(R.id.sourButton);
        salsa = findViewById(R.id.salButton);
        guac = findViewById(R.id.gButton);

        places = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this, R.array.places, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        places.setAdapter(adapter);
        places.setOnItemSelectedListener(this);


        buildBurrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameText.getText().toString();
                if(name.equals("Name")){
                    Toast.makeText(getApplicationContext(), "Enter a name", Toast.LENGTH_SHORT).show();
                }
                else {                                      //TYPE OF MEAT
                    if(toggleType.isChecked()){
                        name = name + " wants a veggie ";
                    }
                    else{
                        name = name + " wants a meaty ";
                    }

                    if(casing.isChecked()){
                        name = name + "gluten Free ";
                    }

                    name = name + "Burrito, with: ";

                    if(sour.isChecked()){
                        name = name + "sour cream ";
                    }
                    if(guac.isChecked()){
                        name = name + "guac ";
                    }
                    if(cheese.isChecked()){
                        name = name + "cheese ";
                    }
                    if(salsa.isChecked()){
                        name = name + "salsa";
                    }


//                    places.getItemAtPosition()







//                    response.setText(name);
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
