package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "tag";
    StringBuilder screenText;
    TextView screenTextView;
    double result1; double result2; String operator; Double newResult; String returnResult;
    Button buttonOne; Button buttonTwo; Button buttonThree;
    Button buttonFour; Button buttonFive; Button buttonSix;
    Button buttonSeven; Button buttonEight; Button buttonNine; Button buttonZero;
    Button buttonAdd; Button buttonSubtract; Button buttonDivide; Button buttonMultiply;
    Button buttonDelete; Button buttonClear; Button buttonDot; Button buttonEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screenText = new StringBuilder();
        screenTextView = findViewById(R.id.textScreenTextView);
        buttonOne = findViewById(R.id.one);
        buttonTwo = findViewById(R.id.two);
        buttonThree = findViewById(R.id.three);
        buttonFour = findViewById(R.id.four);
        buttonFive = findViewById(R.id.five);
        buttonSix = findViewById(R.id.six);
        buttonSeven = findViewById(R.id.seven);
        buttonEight = findViewById(R.id.eight);
        buttonNine = findViewById(R.id.nine);
        buttonZero = findViewById(R.id.zero);
        buttonAdd = findViewById(R.id.add);
        buttonSubtract = findViewById(R.id.subtract);
        buttonDivide = findViewById(R.id.divide);
        buttonMultiply = findViewById(R.id.multiply);
        buttonDelete = findViewById(R.id.delete);
        buttonClear = findViewById(R.id.clear);
        buttonDot = findViewById(R.id.dot);
        buttonEqual = findViewById(R.id.equal);

        init();
    }
    private void init(){
        buttonOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                screenText.append("1");
                screenTextView.setText(screenText.toString());
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                screenText.append("2");
                screenTextView.setText(screenText.toString());
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                screenText.append("3");
                screenTextView.setText(screenText.toString());
            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                screenText.append("4");
                screenTextView.setText(screenText.toString());
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                screenText.append("5");
                screenTextView.setText(screenText.toString());
            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                screenText.append("6");
                screenTextView.setText(screenText.toString());
            }
        });
        buttonSeven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                screenText.append("7");
                screenTextView.setText(screenText.toString());
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                screenText.append("8");
                screenTextView.setText(screenText.toString());
            }
        });
        buttonNine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                screenText.append("9");
                screenTextView.setText(screenText.toString());
            }
        });
        buttonZero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                screenText.append("0");
                screenTextView.setText(screenText.toString());
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (screenText.toString().isEmpty())
                    screenText.append("0.");
                else
                    screenText.append(".");
                screenTextView.setText(screenText.toString());
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                screenText = new StringBuilder();
                screenTextView.setText("0");
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int i = screenText.length();
                if (i==0)
                    return;
                screenText.deleteCharAt(i-1);
                if (i==1){
                    screenTextView.setText("0");
                    return;
                }
                screenTextView.setText(screenText.toString());

            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result1 =  Double.valueOf(screenTextView.getText().toString());
                operator = "+";
                screenText = new StringBuilder();
                screenTextView.setText("+");
            }
        });
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result1 =  Double.valueOf(screenTextView.getText().toString());
                operator = "-";
                screenText = new StringBuilder();
                screenTextView.setText("-");
                //if statement for negative
            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result1 =  Double.valueOf(screenTextView.getText().toString());
                operator = "x";
                screenText = new StringBuilder();
                screenTextView.setText("x");
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result1 =  Double.valueOf(screenTextView.getText().toString());
                operator = "/";
                screenText = new StringBuilder();
                screenTextView.setText("/");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                result2 = Double.valueOf(screenTextView.getText().toString());
                switch (operator){
                    case "+":
                        Double newResults = result1 + result2;
                        //returnResult = result1 + "+" +result2 +"=" + newResults;
                        screenText = new StringBuilder();
                        screenText.append(newResults);
                        screenTextView.setText(screenText.toString());
                        break;
                    case "-":
                        newResult = result1 - result2;
                        screenText = new StringBuilder();
                        screenText.append(newResult.toString());
                        screenTextView.setText(screenText.toString());
                        break;
                    case "x":
                        newResult = result1 * result2;
                        screenText = new StringBuilder();
                        screenText.append(newResult.toString());
                        screenTextView.setText(screenText.toString());
                        break;
                    case "/":
                        newResult = result1/result2;
                        screenText = new StringBuilder();
                        screenText.append(newResult.toString());
                        screenTextView.setText(screenText.toString());
                        break;
                }
            }
        });

    }
}