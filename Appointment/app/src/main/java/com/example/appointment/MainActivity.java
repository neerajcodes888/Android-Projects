package com.example.appointment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    String []arr1 = {"Eye", "Bone", "Ear", "Heart"};
    String []arr2 = {"Shrivastav","Ramakanta","B.K.Chawla","Mrs.Mehta"};

    String strGender;
    String spn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner1 = findViewById(R.id.Specility);
        Spinner spinner2 = findViewById(R.id.Name);

        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arr2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),arr2[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arr1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), arr1[i], Toast.LENGTH_SHORT).show();
                int id  = spinner1.getSelectedItemPosition();
                spn1 = arr1[i];
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


//        For Dropdown of spinner and toast after select a element***********

//        ArrayAdapter ap1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,arr1);
//        ap1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner1.setAdapter(ap1);
//
//        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),arr1[i],Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });


        Button submitButton = findViewById(R.id.Btn);
        EditText name = findViewById(R.id.name);
        EditText email = findViewById(R.id.email);
        RadioGroup gender = findViewById(R.id.radio);
        EditText Code = findViewById(R.id.cCode);
        EditText phone = findViewById(R.id.phone);
        EditText date = findViewById(R.id.Date);



        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                Toast.makeText(getApplicationContext(),i,Toast.LENGTH_SHORT).show();
                RadioButton radioButton = findViewById(i);
                strGender = radioButton.getText().toString();

            }
        });

        
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("gender", strGender);
                intent.putExtra("code",Code.getText().toString());
                intent.putExtra("phone", phone.getText().toString());
                intent.putExtra("dcSc",spn1);
                intent.putExtra("Date",date.getText().toString());

                startActivity(intent);
            }
        });


    }


}