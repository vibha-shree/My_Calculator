package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean isOpPressed = false;

    private double firstNumber = 0;
    private  int secondNumberIndex = 0;
    private char currentOp =0;
    private  boolean isDot = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayout);
        final TextView calculatorScreen = findViewById(R.id.calculatorScreen);
        final Button n0 = findViewById(R.id.n0);
        final Button n1 = findViewById(R.id.n1);
        final Button n2 = findViewById(R.id.n2);
        final Button n3 = findViewById(R.id.n3);
        final Button n4 = findViewById(R.id.n4);
        final Button n5 = findViewById(R.id.n5);
        final Button n6 = findViewById(R.id.n6);
        final Button n7 = findViewById(R.id.n7);
        final Button n8 = findViewById(R.id.n8);
        final Button n9 = findViewById(R.id.n9);
        final Button dot = findViewById(R.id.dot);
        final Button equals = findViewById(R.id.equals);
        final Button addition = findViewById(R.id.addition);
        final Button subtraction = findViewById(R.id.subtraction);
        final Button multiplication = findViewById(R.id.multiplication);
        final Button division = findViewById(R.id.division);

        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id = v.getId();
                switch (id) {
                    case R.id.n0:
                        calculatorScreen.append("0");
                        break;
                    case R.id.n1:
                        calculatorScreen.append("1");
                        break;
                    case R.id.n2:
                        calculatorScreen.append("2");
                        break;
                    case R.id.n3:
                        calculatorScreen.append("3");
                        break;
                    case R.id.n4:
                        calculatorScreen.append("4");
                        break;
                    case R.id.n5:
                        calculatorScreen.append("5");
                        break;
                    case R.id.n6:
                        calculatorScreen.append("6");
                        break;
                    case R.id.n7:
                        calculatorScreen.append("7");
                        break;
                    case R.id.n8:
                        calculatorScreen.append("8");
                        break;
                    case R.id.n9:
                        calculatorScreen.append("9");
                        break;
                    case R.id.dot:
                        if(!isDot){
                            calculatorScreen.append(".");
                            isDot = true;
                        }


                        break;
                    case R.id.equals:
                        if(isOpPressed){
                            isOpPressed = false;
                            String screenContent = calculatorScreen.getText().toString();
                            String secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                            double secondNumber = Double.parseDouble(secondNumberString);

                            if (currentOp=='+') {
                                secondNumber += firstNumber;
                            }else if (currentOp=='-'){
                                secondNumber = firstNumber - secondNumber;
                            } else if (currentOp =='*'){
                                secondNumber *= firstNumber;
                            } else if (currentOp =='/'){
                                if(secondNumber==0){
                                    Toast.makeText(MainActivity.this, "ERROR:Divide by zero", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                secondNumber = firstNumber/secondNumber;
                            }

                            String result = String.valueOf(secondNumber);
                            if(result.endsWith(".0")){
                                result = result.substring(0,result.length()-2);
                            }
                            calculatorScreen.setText(result);
                        }

                        break;
                    case R.id.addition:
                        String screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex = screenContent.length()+1;
                                firstNumber = Double.parseDouble(screenContent);
                        calculatorScreen.append("+");
                        isOpPressed = true;
                        isDot = false;
                        currentOp = '+';
                        break;
                    case R.id.subtraction:
                        screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex = screenContent.length()+1;
                        firstNumber = Double.parseDouble(screenContent);
                        calculatorScreen.append("-");
                        isOpPressed = true;
                        isDot = false;
                        currentOp = '-';

                        break;
                    case R.id.multiplication:
                        screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex = screenContent.length()+1;
                        firstNumber = Double.parseDouble(screenContent);
                        calculatorScreen.append("*");
                        isOpPressed = true;
                        isDot = false;
                        currentOp = '*';

                        break;
                    case R.id.division:
                        screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex = screenContent.length()+1;
                        firstNumber = Double.parseDouble(screenContent);
                        calculatorScreen.append("/");
                        isOpPressed = true;
                        isDot = false;
                        currentOp = '/';

                        break;

                }
            }
        };
        n0.setOnClickListener(calculatorListener);
        n1.setOnClickListener(calculatorListener);
        n2.setOnClickListener(calculatorListener);
        n3.setOnClickListener(calculatorListener);
        n4.setOnClickListener(calculatorListener);
        n5.setOnClickListener(calculatorListener);
        n6.setOnClickListener(calculatorListener);
        n7.setOnClickListener(calculatorListener);
        n8.setOnClickListener(calculatorListener);
        n9.setOnClickListener(calculatorListener);
        dot.setOnClickListener(calculatorListener);
        equals.setOnClickListener(calculatorListener);
        addition.setOnClickListener(calculatorListener);
        subtraction.setOnClickListener(calculatorListener);
        multiplication.setOnClickListener(calculatorListener);
        division.setOnClickListener(calculatorListener);

        final Button delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayedElements = calculatorScreen.getText().toString();
                int length = displayedElements.length();
                if(length>0) {
                    displayedElements = displayedElements.substring(0,length-1);
                    calculatorScreen.setText(displayedElements);
                }

            }
        });
        final Button clearEverything = findViewById(R.id.cleareverything);
        clearEverything.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorScreen.setText("");
                isOpPressed = false;
                isDot = false;
            }
        });
    }
}
