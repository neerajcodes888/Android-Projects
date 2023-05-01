package com.example.emi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText loanamt,interest,period;
        Button calculate;
        TextView monthlyEMI,totalInterest,totalpayment;

        loanamt = findViewById(R.id.loanAmt);
        interest = findViewById(R.id.interest);
        period = findViewById(R.id.period);

        calculate=findViewById(R.id.calculate);
        monthlyEMI=findViewById(R.id.emiamt);
        totalInterest = findViewById(R.id.TotalInterest);
        totalpayment=findViewById(R.id.Totalpayment);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float loan = Float.parseFloat(loanamt.getText().toString());
                float i = Float.parseFloat(interest.getText().toString());
                float p = Float.parseFloat(period.getText().toString());
                float totalem = loan*i + loan;
                float totali=loan * i;
                float totalpay=totalem+totali;
                monthlyEMI.setText("EMI : " +totalem);
                totalInterest.setText("Total Interest : " + totali);
                totalpayment.setText("Total Payment  : " + totalpay);
            }
        });
}
}