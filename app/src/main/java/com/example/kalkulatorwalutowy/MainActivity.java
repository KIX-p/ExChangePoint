package com.example.kalkulatorwalutowy;

import static java.lang.Math.round;

import androidx.appcompat.app.AppCompatActivity;

import android.app.admin.SystemUpdatePolicy;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button euro = findViewById(R.id.eur);
        Button dollar = findViewById(R.id.usd);
        Button britishpound = findViewById(R.id.gbp);

        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    EditText zloty = findViewById(R.id.zloty);
                    EditText wynik = findViewById(R.id.result);
                    BigDecimal zl = BigDecimal.valueOf(Double.parseDouble(zloty.getText().toString()));
                    BigDecimal converttoeuro = zl.multiply(BigDecimal.valueOf(0.2305));
                    converttoeuro = converttoeuro.setScale(2, RoundingMode.HALF_UP);
                    wynik.setText(String.valueOf(converttoeuro));
                }
                catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "nie ma danych", Toast.LENGTH_LONG).show();
                }

            }
        });

        dollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    EditText zloty = findViewById(R.id.zloty);
                    EditText wynik = findViewById(R.id.result);
                    BigDecimal zl = BigDecimal.valueOf(Double.parseDouble(zloty.getText().toString()));
                    BigDecimal converttodollar = zl.multiply(BigDecimal.valueOf(0.2479));
                    converttodollar = converttodollar.setScale(2, RoundingMode.HALF_UP);
                    wynik.setText(String.valueOf(converttodollar));
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "nie ma danych", Toast.LENGTH_LONG).show();
                }

            }
        });

        britishpound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    EditText zloty = findViewById(R.id.zloty);
                    EditText wynik = findViewById(R.id.result);
                    BigDecimal zl = BigDecimal.valueOf(Double.parseDouble(zloty.getText().toString()));
                    BigDecimal converttobritishpound = zl.multiply(BigDecimal.valueOf(0.1980));
                    converttobritishpound = converttobritishpound.setScale(2, RoundingMode.HALF_UP);
                    wynik.setText(String.valueOf(converttobritishpound));
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "nie ma danych", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}