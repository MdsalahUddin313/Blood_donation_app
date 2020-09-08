package com.example.blooddonationapp.Auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blooddonationapp.R;
import com.example.blooddonationapp.Third_part;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private TextView signUp;
    private EditText email_login_txt,Password_login_txt;
    private Button Sign_in_btn;
    private ProgressBar progressbar;

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signUp=(TextView)findViewById(R.id.signUp_text);
        Sign_in_btn=(Button) findViewById(R.id.button_signin);
        email_login_txt=(EditText) findViewById(R.id.email_login_id);
        Password_login_txt=(EditText) findViewById(R.id.password_login_id);
        progressbar=(ProgressBar)findViewById(R.id.progressbar_login_id);
        init_click_listener();

    }

    private void init_click_listener() {
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this,Signup.class);startActivity(i);
            }
        });
        Sign_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRegister();
            }
        });
    }

    private void userRegister() {

        String Email=email_login_txt.getText().toString().trim();
        String Password =Password_login_txt.getText().toString().trim();
        // String Username=userName.getText().toString().trim();
        //  String Password =signupPassword.getText().toString().trim();
        if(Password.isEmpty()){
            Password_login_txt.setError("Enter an Password");
            Password_login_txt.requestFocus();
            return;
        }

        if(Password.length()<6){
            Password_login_txt.setError("Minimum length 6 character!!!");
            Password_login_txt.requestFocus();
            return;
        }
        if(Email.isEmpty()){
            email_login_txt.setError("Enter an Email address");
            email_login_txt.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            email_login_txt.setError("Enter an valid Email address");
            email_login_txt.requestFocus();
            return;
        }

        /*
          if(firstname.isEmpty()){
            signupFirstName.setError("Enter Your name.");
            signupFirstName.requestFocus();
            return;
        }

        if(Password.length()<2){
            signupFirstName.setError("Minimum length 2 character!!!");
            signupFirstName.requestFocus();
            return;
        }

         */
        progressbar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressbar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Login.this, Third_part.class);startActivity(i);

                }else{
                    Toast.makeText(getApplicationContext(),"Login not Successful",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}