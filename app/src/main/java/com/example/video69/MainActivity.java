package com.example.video69;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.media.AudioFormat;
import android.media.MediaRecorder;
import android.media.RingtoneManager;
import android.os.Build;
//import android.support.annotation.NonNull;
//import android.support.design.widget.NavigationView;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;

import java.io.IOException;
import java.util.Locale;

import static com.example.video69.theme.gg;


//import static com.example.video69.theme.gg;


public class MainActivity extends AppCompatActivity {
    MediaRecorder recorder;
    Button btnstart;
    Button btnstop, dark, light;
    Context context;
    public static ImageView micrecord, imgrecord, imglogo;
    TextView txttime;
    public static DrawerLayout drawerLayout;
    public static NavigationView navigationView;
    public static Toolbar toolbar;
    LinearLayout linearLayout;

    public static LinearLayout relativeLayout;

    SharedPreferences preferences;

    int id = 1000;
    String rezaa;


    Thread thread;
    int sec = 0;
    int min = 0;
    boolean isrecording = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.navigation);


        micrecord = (ImageView) findViewById(R.id.micrecord);
        imgrecord = (ImageView) findViewById(R.id.imgrecord);
        txttime = (TextView) findViewById(R.id.txttime);
        imglogo = (ImageView) findViewById(R.id.Imglogo);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.navigation);


        toolbar = (Toolbar) findViewById(R.id.toolbar);


        relativeLayout = (LinearLayout) findViewById(R.id.reletiv);
        changetheme();


//        imglogo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                drawerLayout.openDrawer(Gravity.RIGHT);
//            }
//        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.setting) {

                    Intent intent = new Intent(MainActivity.this, Activityfiles.class);
                    startActivity(intent);


                }
                if (id == R.id.exit) {
                    finish();
                }
                if (id == R.id.theme) {
                    Intent intent = new Intent(MainActivity.this, theme.class);
                    startActivity(intent);
                }
                return true;
            }
        });


        if (Build.VERSION.SDK_INT >= 23) {
            String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO};
            Permissions.check(this/*context*/, permissions, null/*rationale*/, null/*options*/, new PermissionHandler() {
                @Override
                public void onGranted() {


                }
            });
        }


        imgrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!isrecording) {
                    isrecording = true;
                    thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (isrecording) {
                                try {
                                    Thread.sleep(1000);
                                    if (sec != 59) {
                                        sec++;
                                    } else {
                                        sec = 0;
                                        min++;
                                    }
                                    G.handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            txttime.setText(min + ":" + sec);

                                            //time=(min+":"+sec);
                                            if (isrecording == true) {

                                                final Notification notification = new Notification.Builder(getApplicationContext())
                                                        .setSmallIcon(R.drawable.recorder)
                                                        .setContentTitle("Voice Recorder")
                                                        //.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                                                        .setContentText("Recording: " + min + ":" + sec)
                                                        //.setPriority(Notification.PRIORITY_MAX)
                                                        .setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.recorder))
                                                        //.addAction(R.mipmap.ic_launcher_round,"Reza_motahari",pendingIntent)
                                                        // .setStyle(bigPictureStyle)
                                                        //    .setStyle(bigTextStyle)
                                                        .setOngoing(true)


                                                        .build();

                                                NotificationManager notificationManager = (NotificationManager) getSystemService(context.NOTIFICATION_SERVICE);
                                                notificationManager.notify(id, notification);


                                            }


                                        }
                                    });
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                        }

                    });


                    thread.start();


                    imgrecord.setImageResource(R.drawable.stop);
                    micrecord.setImageResource(R.drawable.mic);
                    // MediaRecorder recorder;
                    recorder = new MediaRecorder();


                    recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

                    recorder.setOutputFile(G.address + "/" + System.currentTimeMillis() + ".3gp");
                    recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);


                    try {
                        recorder.prepare();
                        recorder.start();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {

                    isrecording = false;
                    // imgrecord.setImageResource(R.drawable.record);


                    Notification notification = new Notification.Builder(getApplicationContext())
                            .setSmallIcon(R.drawable.recorder)
                            .setContentTitle("Recording finish")
                            .setContentText("File is saved")
                            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                            //.setPriority(Notification.PRIORITY_MAX)
                            .setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.recorder))
//                .addAction(R.mipmap.ic_launcher_round,"Reza_motahari",pendingIntent)
                            // .setStyle(bigPictureStyle)
                            //    .setStyle(bigTextStyle)
                            .setOngoing(false)
                            .build();

                    NotificationManager notificationManager = (NotificationManager) getSystemService(context.NOTIFICATION_SERVICE);
                    notificationManager.notify(id, notification);


                    sec = -1;
                    min = 0;
                    imgrecord.setImageResource(R.drawable.record);
                    micrecord.setImageResource(R.drawable.micc);
                    recorder.release();


                }


            }
        });


        if (Build.VERSION.SDK_INT >= 23) {
            Permissions.check(this/*context*/, Manifest.permission.RECORD_AUDIO, null, new PermissionHandler() {
                @Override
                public void onGranted() {


                }
            });
        }


        imglogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                drawerLayout.openDrawer(Gravity.RIGHT);


            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            drawerLayout.closeDrawer(Gravity.RIGHT);
        } else {
            super.onBackPressed();
        }
    }


    public String settime(Long duration) {
        int secc = (int) (duration / 1000);
        int minn = secc / 60;
        secc = secc % 60;
        return String.format(Locale.ENGLISH, "%02d", minn) + ":" + String.format(Locale.ENGLISH, "%02d", secc);
        //با دو رقم اعشار نشان می دهد


    }

    public void changetheme() {
        SharedPreferences preferences = getSharedPreferences("theme", MODE_PRIVATE);
        int s = preferences.getInt("color", 1);
        if (s == 2) {
            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        }

        if (s == 1) {
            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.pink));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.pink));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.pink));
        } else if (s == 3) {

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));

        } else if (s == 4) {

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.color2));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.color2));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.color2));

        } else if (s == 5) {

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
        } else if (s == 6) {

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.orange));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.orange));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.orange));
        } else if (s == 7) {

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
        } else if (s == 8) {

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.yellow));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.yellow));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.yellow));
        } else if (s == 9) {

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.brown));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.brown));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.brown));
        } else if (s == 10) {

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.pink2));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.pink2));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.pink2));
        } else if (s == 11) {
            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.purple));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.purple));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.purple));
        } else if (s == 12) {

            relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.cyan));
            drawerLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.cyan));
            navigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.cyan));
        }

    }


}
