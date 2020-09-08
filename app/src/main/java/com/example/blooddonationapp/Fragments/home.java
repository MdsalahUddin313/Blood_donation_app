package com.example.blooddonationapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.blooddonationapp.R;
import com.example.blooddonationapp.Request_user.Request_donor_for_donate;
import com.example.blooddonationapp.Request_user.Request_for_blood;


public class home extends Fragment implements View.OnClickListener{
    ImageButton donor,request;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup= (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        donor=viewGroup.findViewById(R.id.donate_blood_id);donor.setOnClickListener(this);
        request=viewGroup.findViewById(R.id.request_for_blood_id);request.setOnClickListener(this);
    return  viewGroup;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.request_for_blood_id:
                Intent i= new Intent(getActivity(), Request_for_blood.class);startActivity(i);
                break;
            case R.id.donate_blood_id:
                Intent i2= new Intent(getActivity(), Request_donor_for_donate.class);startActivity(i2);
                break;
        }
    }
}