package com.example.video69;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;


import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.video69.MainActivity.drawerLayout;
import static com.example.video69.MainActivity.navigationView;
import static com.example.video69.MainActivity.relativeLayout;

public class theme extends AppCompatActivity {

    CircleImageView pink,green, gray,color2,blue,orange,red,yellow,brown,pink2,purple,cyan;
    LinearLayout thiss;

    public static int gg=R.color.colorPrimary ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        thiss=(LinearLayout)findViewById(R.id.thiss);


        pink=(CircleImageView)findViewById(R.id.pink);
        green=(CircleImageView)findViewById(R.id.green);
        gray =(CircleImageView)findViewById(R.id.gray);
        color2 =(CircleImageView)findViewById(R.id.color2);
        blue=(CircleImageView)findViewById(R.id.blue);
        orange=(CircleImageView)findViewById(R.id.orange);
        yellow=(CircleImageView)findViewById(R.id.yelow);
        red=(CircleImageView)findViewById(R.id.red);
        brown=(CircleImageView)findViewById(R.id.brown);
        pink2=(CircleImageView)findViewById(R.id.pink2);
        purple=(CircleImageView)findViewById(R.id.purple);
        cyan=(CircleImageView)findViewById(R.id.cyan);

        getColor();

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",R.color.colorPrimary);
                editor.commit();
                recreate();
            }
        });


        pink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",R.color.pink);
                editor.commit();
                recreate();
            }
        });
        gray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",R.color.gray);
                editor.commit();
                recreate();

            }
        });
        color2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",R.color.color2);
                editor.commit();
                recreate();

            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",R.color.blue);
                editor.commit();
                recreate();

            }
        });
       orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",R.color.orange);
                editor.commit();
                recreate();

            }
        });
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",R.color.red);
                editor.commit();
                recreate();

            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",R.color.yellow);
                editor.commit();
                recreate();

            }
        });
        brown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",R.color.brown);
                editor.commit();
                recreate();

            }
        });
        pink2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",R.color.pink2);
                editor.commit();
                recreate();

            }
        });
        purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",R.color.purple);
                editor.commit();
                recreate();

            }
        });
        cyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",R.color.cyan);
                editor.commit();
                recreate();

            }
        });
    }



    public void getColor()
    {
        SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);

        int b=changeTheme.getInt("color",R.color.colorPrimary);

                    gg =b;
            relativeLayout.setBackgroundColor(getResources().getColor(b));
            drawerLayout.setBackgroundColor(getResources().getColor(b));
            navigationView.setBackgroundColor(getResources().getColor(b));
           thiss.setBackgroundColor(getResources().getColor(b));

    }

}








