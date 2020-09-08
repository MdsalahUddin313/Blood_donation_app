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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity  implements View.OnClickListener{

    private EditText userName,PassWord,Email_add,Course_name,AGE,BloodGroup;
    private ProgressBar progressbar;
    private Button submit_button;
    private TextView sign_uptext;
    DatabaseReference databaseReference;

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init_components();
    }
    private void init_components() {
        userName=(EditText)findViewById(R.id.username_edit_text);
        PassWord =(EditText)findViewById(R.id.Password);
        Email_add=(EditText)findViewById(R.id.Email_id);
        Course_name=(EditText)findViewById(R.id.CourseName);
        AGE=(EditText)findViewById(R.id.Age);
        BloodGroup=(EditText)findViewById(R.id.BloodGroup_id);
        submit_button=(Button) findViewById(R.id.Submit);
        sign_uptext=(TextView) findViewById(R.id.signUp_text);
        progressbar = (ProgressBar) findViewById(R.id.progressbarid);
        // FirebaseAuth mAuth = FirebaseAuth.getInstance();


        databaseReference= FirebaseDatabase.getInstance().getReference("User_data_tree");
        mAuth = FirebaseAuth.getInstance();


        submit_button.setOnClickListener(this);
        sign_uptext.setOnClickListener(this);



    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Submit:
                Toast.makeText(getApplicationContext(),"Clicked Submit",Toast.LENGTH_SHORT).show();
                userRegister();
                break;

            case R.id.signUp_text:
                Intent i = new Intent(Signup.this,Login.class);
                startActivity(i);
                break;
        }
    }


    private void userInforamtion_data_Save() {

        String Username=userName.getText().toString().trim();
        String  password=PassWord.getText().toString().trim();
        String   Email =Email_add.getText().toString().trim();
        String   Age=AGE.getText().toString().trim();
        String   CourseName=Course_name.getText().toString().trim();
        String  Blood_Group=BloodGroup.getText().toString().trim();


        try{
            String key=databaseReference.push().getKey();
            UserData_manage Userdata=new UserData_manage(Username,Email,password,CourseName,Blood_Group,Age);
            databaseReference.child(key).setValue(Userdata);
            Toast.makeText(getApplicationContext(),"Input data successful",Toast.LENGTH_SHORT).show();

        }catch(Exception e){}


    }

    private void userRegister() {
        userInforamtion_data_Save();
        String Email=Email_add.getText().toString().trim();
        String Password =PassWord.getText().toString().trim();
        String Username=userName.getText().toString().trim();
        //  String Password =signupPassword.getText().toString().trim();
        if(Password.isEmpty()){
            PassWord.setError("Enter an Password");
            PassWord.requestFocus();
            return;
        }

        if(Password.length()<6){
            PassWord.setError("Minimum length 6 character!!!");
            PassWord.requestFocus();
            return;
        }
        if(Email.isEmpty()){
            Email_add.setError("Enter an Email address");
            Email_add.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            Email_add.setError("Enter an valid Email address");
            Email_add.requestFocus();
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

        mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressbar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Register is success ful",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(),"Register is not successfull",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}