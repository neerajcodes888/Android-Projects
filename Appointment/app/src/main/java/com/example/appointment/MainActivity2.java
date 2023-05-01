package com.example.appointment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView text = findViewById(R.id.text);
        String str1 = getIntent().getStringExtra("name");
        String str2 = getIntent().getStringExtra("email");
        String strGender = getIntent().getStringExtra("gender");
        String strCode = getIntent().getStringExtra("code");
        String strPhone = getIntent().getStringExtra("phone");
        String strS = getIntent().getStringExtra("dcSp");
        String strDate = getIntent().getStringExtra("Date");


        text.setText("Name: "+str1 + "\nEmail:  "+str2 +"\nGender:"+strGender + "\nPhone: "+strCode+" "+strPhone+"\nSpecility: "+strS+"\nDate: "+strDate);

    }
}