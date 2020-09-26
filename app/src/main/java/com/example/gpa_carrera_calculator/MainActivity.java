package com.example.gpa_carrera_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // To contain the grades
    private EditText g1;
    private EditText g2;
    private EditText g3;
    private EditText g4;
    private EditText g5;

    private Button b1;

    // Will display GPA
    private TextView t1;

    private  ScrollView s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting the grades
        g1 = (EditText) findViewById(R.id.Grade1);
        g2 = (EditText) findViewById(R.id.Grade2);
        g3 = (EditText) findViewById(R.id.Grade3);
        g4 = (EditText) findViewById(R.id.Grade4);
        g5 = (EditText) findViewById(R.id.Grade5);

        b1 = (Button) findViewById(R.id.btn1);

        t1 = (TextView) findViewById(R.id.GPA);

        // To change the background
        s1 = (ScrollView) findViewById(R.id.scrollView);
    }

    public void calculateGPA(View view) {
        double sum;
        double gpa;

        if ( g1.getText().toString().isEmpty() || g2.getText().toString().isEmpty()
                || g3.getText().toString().isEmpty() || g4.getText().toString().isEmpty()
                || g5.getText().toString().isEmpty() ) {

            t1.setText(R.string.emptySpace);
        }
        else {
            double grade1 = Double.parseDouble(g1.getText().toString());
            double grade2 = Double.parseDouble(g2.getText().toString());
            double grade3 = Double.parseDouble(g3.getText().toString());
            double grade4 = Double.parseDouble(g4.getText().toString());
            double grade5 = Double.parseDouble(g5.getText().toString());

            sum = grade1 + grade2 + grade3 + grade4 + grade5;
            gpa = sum / 5.0;

            if (gpa < 61) {
                s1.setBackgroundColor(Color.RED);
            }
            else if (gpa < 80) {
                s1.setBackgroundColor(Color.YELLOW);
            }
            else {
                s1.setBackgroundColor(Color.GREEN);
            }

            t1.setText(String.valueOf(gpa));

            b1.setText(null);
        }
    }
}