package com.example.blooddonationapp.Profiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.blooddonationapp.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Users_profile extends AppCompatActivity {
 private CircleImageView user_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_profile);
    }
}