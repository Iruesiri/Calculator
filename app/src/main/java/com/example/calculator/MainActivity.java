package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
   //public static final String TAG = "tag";
    StringBuilder screenText;
    TextView screenTextView;
    double result1 = 0;
    double result2 = 0;
    String operator = "";
    Double newResult; Double negateResult; String returnResult;
    Button buttonOne; Button buttonTwo; Button buttonThree; Button buttonPercent;
    Button buttonFour; Button buttonFive; Button buttonSix; Button buttonNegate;
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
        buttonNegate = findViewById(R.id.negate);
        buttonPercent = findViewById(R.id.percent);

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
                try {
                    if (screenText.toString().isEmpty())
                        screenText.append("0.");
                    else
                        screenText.append(".");
                    screenTextView.setText(screenText.toString());
                }
                catch (Exception e){}
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                screenText = new StringBuilder();
                screenTextView.setText("0");
                result1 = 0;
                operator = "";
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
        buttonPercent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try {
                    double result =  Double.valueOf(screenTextView.getText().toString());
                    Double percentResult = result/100;
                    screenText = new StringBuilder();
                    screenText.append(percentResult.toString());
                    screenTextView.setText(screenText.toString());
                }
                catch (Exception e){
                }
            }
        });
        buttonNegate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try {
                    double result =  Double.valueOf(screenTextView.getText().toString());
                    negateResult = 0 - result;
                    screenText = new StringBuilder();
                    screenText.append(negateResult.toString());
                    screenTextView.setText(screenText.toString());
                }
                catch (Exception e){
                }
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    result1 =  operations(operator,Double.valueOf(screenTextView.getText().toString()));
                    operator = "+";
                    screenText = new StringBuilder();
                    screenTextView.setText("+");
                }
                catch (Exception e){}
            }
        });
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    result1 =  operations(operator,Double.valueOf(screenTextView.getText().toString()));
                    operator = "-";
                    screenText = new StringBuilder();
                    screenTextView.setText(" -");
                }
                catch (Exception e){
                    screenText.append("Invalid input");
                    screenTextView.setText(screenText.toString());
                }
            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    result1 =  operations(operator,Double.valueOf(screenTextView.getText().toString()));
                    operator = "x";
                    screenText = new StringBuilder();
                    screenTextView.setText("x");
                }
                catch (Exception e){}
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    result1 =  operations(operator,Double.valueOf(screenTextView.getText().toString()));
                    operator = "/";
                    screenText = new StringBuilder();
                    screenTextView.setText("/");
                }
                catch (Exception e){}
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try {
                    result2 = Double.valueOf(screenTextView.getText().toString());
                    screenText = new StringBuilder();
                    if (operator.equals("/")) {
                        if (result2 == 0)
                            screenText.append("Cannot divide by zero");
                        else
                            newResult = operations(operator, result2);
                    } else
                        newResult = operations(operator, result2);
                    screenText.append(newResult);
                    screenTextView.setText(screenText.toString());
                    result1 = 0;
                    screenText = new StringBuilder();
                    operator = "";
                }
                catch (Exception e){
                    screenText.append("Invalid input");
                    screenTextView.setText(screenText.toString());
                    screenText = new StringBuilder();
                    //screenTextView.setText(screenText.toString());
                }
            }
        });
    }
    private Double operations(String operator, Double val){
        Double returnValue = 0.0;
        switch (operator) {
            case "+":
                returnValue = result1 + val;
                break;
            case "-":
                returnValue = result1 - val;
                break;
            case "x":
                returnValue = result1 * val;
                break;
            case "/":
                returnValue = result1 / val;
                break;
            case "":
                returnValue = val;
                break;
        }
        return returnValue;
    }
}