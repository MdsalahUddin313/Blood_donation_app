package com.example.blooddonationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private Button btn1;
private TextView text1,text2,text3,text4;

String[] features= {"1.Admin panel with user imformation..(Approve and delete request)\n" +
        "2.Making a Donor's List..\n" +
        "3.Show donors in google map location....\n\n\n\n"};
    String[] terms={"1.When we give u any update,analize it carefully and suggest exact features what we need to do.If we start working an terms it will be difficult to switch in another terms (suppose we working on google map in that time you couldn't tell us to add another features instead of map..)..\n" +
            "2.After Doinng Project structure and design part you should pay 30-50% money in advance.Otherwise we can't work further.\n" +
            "3.We always give you update for this project(weekly).We started your project from 4/9/2020 and will end this project at 24/9/2020.If you have any problem in giving us such time please discuss with us...\n\n\n\n"};
    String[] project_structure={"1.Making Architecture\n" +
            "2.Making an attractive Design..\n" +
            "3.Comple app using backened...\n" +
            "4.Testing app\n\n\n"};
    String[] our_work={"1.Making Architecture\n" +
            "2.Try to make an attractive Design..(Material design and Animation (60% done))\n" +
            "3.Login Registration using backened...\n" ,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=findViewById(R.id.text_features);
       // text1.setText(terms.length+"");
        text2=findViewById(R.id.text_steps);
        //text2.setText(project_structure+"");
        text3=findViewById(R.id.text_terms);
       // text3.setText(terms+"");
        text4=findViewById(R.id.text_our_work);
        //text4.setText(our_work+"");





       /// Statusbar_color_change();
    btn1=(Button)findViewById(R.id.btn_one);
    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i=new Intent(MainActivity.this,splash_screen.class);
            startActivity(i);

        }
    });
    }

    void Statusbar_color_change(){
        Window window = getParent().getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(),R.color.redish));
        }
    }


}