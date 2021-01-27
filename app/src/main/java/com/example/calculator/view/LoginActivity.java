package com.example.calculator.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.HttpPracticeActivity;
import com.example.calculator.R;
import com.example.calculator.model.LoginResponse;

public class LoginActivity extends AppCompatActivity implements HttpPracticeActivity.LoginInterface {
    private EditText usernameEditText, passwordEditText;
    private String username, password;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        login = findViewById(R.id.login);

        HttpPracticeActivity httpPracticeActivity = new HttpPracticeActivity(LoginActivity.this);
        httpPracticeActivity.loginResponseArrived(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameEditText.getText().toString();
                password = passwordEditText.getText().toString();
                String[] parameters = {username, password};

                httpPracticeActivity.execute(parameters);


                /*if (username.equals("Esiri") && password.equals("esiri")){
                    Intent intent = new Intent(LoginActivity.this, RecyclerViewActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Username or Password incorrect", Toast.LENGTH_LONG).show();
                }*/
            }
        });
    }

    @Override
    public void loginResponse(LoginResponse response) {

        int statusResponse = response.getStatus();

        if (statusResponse == 1){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, response.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
