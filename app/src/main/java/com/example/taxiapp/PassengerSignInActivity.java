package com.example.taxiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class PassengerSignInActivity extends AppCompatActivity {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputName;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputConfirmPassword;

    private Button loginSignUpButton;
    private TextView TextViewSignUp;
    private boolean loginModeActive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_sign_in);

        textInputEmail = findViewById(R.id.textInputEmailPas);
        textInputName = findViewById(R.id.textInputNamePas);
        textInputPassword = findViewById(R.id.textInputPasswordPas);
        textInputConfirmPassword = findViewById(R.id.textInputConfirmPasswordPas);

        loginSignUpButton = findViewById(R.id.loginSignUpButtonPas);
        TextViewSignUp = findViewById(R.id.TextViewSignUpPas);
    }

    private boolean validateEmail(){
        String inputEmail = textInputEmail.getEditText().getText().toString().trim();

        if(inputEmail.isEmpty()){
            textInputEmail.setError("Please input your email");
            return false;
        } else {
            textInputEmail.setError("");
            return true;
        }
    }

    private boolean validateName(){
        String inputName = textInputName.getEditText().getText().toString().trim();

        if(inputName.isEmpty()){
            textInputName.setError("Please input your name");
            return false;
        } else if(inputName.length() > 15) {
            textInputName.setError("Name length have to be less than 15");
            return false;
        } else {
            textInputName.setError("");
            return true;
        }
    }
    private boolean validatePassword(){
        String inputPassword = textInputPassword.getEditText().getText().toString().trim();
        String inputPasswordConfirm = textInputConfirmPassword.getEditText().getText().toString().trim();

        if(inputPassword.isEmpty()){
            textInputPassword.setError("Please input your password");
            return false;
        } else if(inputPassword.length() < 7) {
            textInputPassword.setError("Password have to be than than 6");
            return false;
        } else if(!inputPasswordConfirm.equals(inputPassword)) {
            textInputConfirmPassword.setError("Password have to match");
            return false;
        }else {
            textInputPassword.setError("");
            return true;
        }
    }


    public void loginSignUp(View view) {
        if(!validateEmail() | !validateName() | !validatePassword()) {
            return;
        }

        String userInfo = "Email: "  + textInputEmail.getEditText().getText().toString().trim() +
                "\n" + "Name: " +  textInputName.getEditText().getText().toString().trim() + "\n" + "Password: " +
                textInputPassword.getEditText().getText().toString().trim();

        Toast.makeText(this, userInfo, Toast.LENGTH_LONG).show();
    }

    public void goToLogin(View view) {
        if(loginModeActive){
            loginModeActive = false;
            loginSignUpButton.setText("Sign Up");
            TextViewSignUp.setText("Tap to Log In");
            textInputConfirmPassword.setVisibility(View.VISIBLE);
        } else {
            loginModeActive=true;
            loginSignUpButton.setText("Log in");
            TextViewSignUp.setText("Tap Sign Up");
            textInputConfirmPassword.setVisibility(View.GONE);
        }
    }
}