package com.example.video69;

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

    public static int gg=1 ;


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
                editor.putInt("color",2);
                editor.commit();
                recreate();
            }
        });


        pink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",1);
                editor.commit();
                recreate();
            }
        });
        gray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",3);
                editor.commit();
                recreate();

            }
        });
        color2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",4);
                editor.commit();
                recreate();

            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",5);
                editor.commit();
                recreate();

            }
        });
       orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",6);
                editor.commit();
                recreate();

            }
        });
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",7);
                editor.commit();
                recreate();

            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",8);
                editor.commit();
                recreate();

            }
        });
        brown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",9);
                editor.commit();
                recreate();

            }
        });
        pink2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",10);
                editor.commit();
                recreate();

            }
        });
        purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",11);
                editor.commit();
                recreate();

            }
        });
        cyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor editor = changeTheme.edit();
                editor.putInt("color",12);
                editor.commit();
                recreate();

            }
        });
    }


    public void getColor()
    {
        SharedPreferences changeTheme = getSharedPreferences("theme",MODE_PRIVATE);

        int b=changeTheme.getInt("color",1);

        if (b==2)
        {

            gg =2;
            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
           thiss.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));

        }
        else if(b==1)
        {
            gg =1;

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.pink));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.pink));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.pink));
            thiss.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.pink));
        }
        else if(b==3)
        {
            gg =3;

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.gray));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.gray));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.gray));
            thiss.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.gray));
        }
        else if(b==4)
        {
            gg =4;

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color2));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color2));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color2));
            thiss.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.color2));
        }
        else if(b==5)
        {
            gg =5;

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.blue));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.blue));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.blue));
            thiss.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.blue));
        }
        else if(b==6)
        {
            gg =6;

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.orange));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.orange));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.orange));
            thiss.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.orange));
        }
        else if(b==7)
        {
            gg =7;

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.red));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.red));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.red));
            thiss.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.red));
        }
        else if(b==8)
        {
            gg =8;

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.yellow));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.yellow));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.yellow));
            thiss.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.yellow));
        }
        else if(b==9)
        {
            gg =9;

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.brown));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.brown));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.brown));
            thiss.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.brown));
        }
        else if(b==10)
        {
            gg =10;

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.pink2));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.pink2));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.pink2));
            thiss.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.pink2));
        }
        else if(b==11)
        {
            gg =11;

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.purple));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.purple));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.purple));
            thiss.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.purple));
        }
        else if(b==12)
        {
            gg =12;

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.cyan));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.cyan));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.cyan));
            thiss.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.cyan));
        }


    }

}








