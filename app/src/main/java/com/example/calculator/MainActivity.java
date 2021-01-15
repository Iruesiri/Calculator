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
    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;
    Button buttonFive;
    Button buttonSix;
    Button buttonSeven;
    Button buttonEight;
    Button buttonNine;
    Button buttonZero;
    Button buttonAdd;
    Button buttonSubtract;
    Button buttonDivide;
    Button buttonMultiply;
    Button buttonDelete;
    Button buttonClear;
    Button buttonDot;
    Button buttonEqual;

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
                Log.d(TAG, "onClick: 1");
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                screenText.append("2");
                screenTextView.setText(screenText.toString());
                Log.d(TAG, "onClick: 2");
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                screenText.append("3");
                screenTextView.setText(screenText.toString());
                Log.d(TAG, "onClick: 3");
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
                String text;
                text = screenTextView.toString();
                int count = text.length();
                String removeLastDigit = screenText.deleteCharAt(count - 1).toString();
                screenText = new StringBuilder();
                screenText.append(removeLastDigit);
                screenTextView.setText(screenText);
            }
        });
    }
}