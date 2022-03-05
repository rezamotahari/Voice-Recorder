package com.example.video69;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
//import android.support.annotation.RequiresApi;
//import android.support.v7.app.AppCompatActivity;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

import android.widget.SeekBar;
import android.widget.TextView;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.video69.theme.gg;


//import static com.example.video69.theme.gg;


public class Activityfiles extends AppCompatActivity {
    private Runnable runnable;

    private Context contextForDialog = null;


    public  ArrayList<String> recordlist;
    public ArrayAdapter<String> adapter;
    public  String address;
    public static ListView lstfile;
    public MediaPlayer player;
    public Handler updateHandler = new Handler();
    public static ImageView imgplay, imgpause, imgstop, delete;
    public int pauseposition;
    public SeekBar seekBar;
    public boolean resume = true, stop = true;
    public  ProgressBar progressBar;
    public AlertDialog.Builder alert;
    public String path;
    public static TextView txttime, txtCurrentTime;
    public Timer timer;


    public static LinearLayout linearLayout;

    public static Context acontext;


    public CheckBox ch;


    ArrayList list = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        contextForDialog = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);

        setupview();
        changetheme();


        address = Environment.getExternalStorageDirectory() + "/VoiceRecorder/my_sounds/".toString();
        recordlist = new ArrayList<String>();
        final File audiofile = new File(address);
        final File listFiles[] = audiofile.listFiles();

        adapter = new ArrayAdapter<String>(G.context, android.R.layout.simple_list_item_1, recordlist);
        for (int i = 0; i < listFiles.length; i++) {
            recordlist.add(listFiles[i].getName());
            lstfile.setAdapter(adapter);

            adapter.notifyDataSetChanged();
        }


        final CheckBox ch = (CheckBox) findViewById(R.id.ch);

        lstfile.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {


                ch.setChecked(true);
                player = new MediaPlayer();
                try {
                    player.setDataSource(listFiles[i].toString());
                    player.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                imgplay.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onClick(View view) {
                        if (ch.isChecked() & resume == true & stop == false) {
                            resume = false;
                            // updateseekbar(true);
                            player.seekTo(pauseposition);
                            timer = new Timer();
                            seekBar.setMax(player.getDuration());
                            timer.schedule(new Mytimer(), 0, 1000);
                            player.start();
                        }


                        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                player.seekTo(0);
                                ch.setChecked(false);
                                seekBar.setProgress(0);
                                resume = true;
                            }
                        });


                        if (ch.isChecked() & resume == true & stop == true) {
                            stop = false;
                            resume = false;
                            // updateseekbar(true);

                            seekBar.setMax(player.getDuration());
                            timer = new Timer();


                            timer.schedule(new Mytimer(), 0, 1000);
                            player.start();


                            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    player.seekTo(0);
                                    ch.setChecked(false);
                                    seekBar.setProgress(0);
                                    resume = true;
                                    stop = true;

                                }
                            });


                        }
                    }
                });

                imgpause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        pauseposition = player.getCurrentPosition();
//                        updateseekbar(false);

                        resume = true;
                        player.pause();


                    }
                });
                imgstop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        player.seekTo(0);
                        stop = true;
                        seekBar.setProgress(0);
                        player.stop();
                        resume = true;
                        ch.setChecked(false);


                    }
                });

                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (ch.isChecked()) {
                            alert = new AlertDialog.Builder(contextForDialog).setMessage("are you sure").setTitle("DELETE FILE")
                                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int k) {
                                            adapter.remove(recordlist.get(i));
                                            String path = listFiles[i].toString();
                                            File file = new File(path);
                                            boolean deleted = file.delete();
                                            ch.setChecked(false);


                                        }
                                    }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int k) {
                                            //  recreate();
                                            alert.setCancelable(true);
                                            ch.setChecked(false);

                                        }
                                    });
                            alert.create().show();
                        }

                    }
                });


                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        seekBar.setProgress(i);
                        player.seekTo(i);


                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {


                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {


                    }
                });


            }


        });


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (ch.isChecked()) {
            player.pause();
        }

    }

    public class Mytimer extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    //seekBar.setProgress(player.getCurrentPosition());

                    txtCurrentTime.setText(settime((long) player.getCurrentPosition()));


                }
            });

        }
    }


    public String settime(Long duration) {
        int sec = (int) (duration / 1000);
        int min = sec / 60;
        sec = sec % 60;
        return String.format(Locale.ENGLISH, "%02d", min) + ":" + String.format(Locale.ENGLISH, "%02d", sec);
        //با دو رقم اعشار نشان می دهد


    }

    public void setupview() {
        lstfile = (ListView) findViewById(R.id.lstfile);
        ch = (CheckBox) findViewById(R.id.ch);

        imgpause = (ImageView) findViewById(R.id.imgpause);
        imgplay = (ImageView) findViewById(R.id.imgplay);
        imgplay.setImageResource(R.drawable.playy);
        imgpause.setImageResource(R.drawable.p);
        imgstop = (ImageView) findViewById(R.id.imgstop);
        txtCurrentTime = (TextView) findViewById(R.id.txtCurrentTime);
        imgstop.setImageResource(R.drawable.stop);
         seekBar = (SeekBar) findViewById(R.id.seekBar);
        delete = (ImageView) findViewById(R.id.delete);
        delete.setImageResource(R.drawable.edit_delete);
        txttime = (TextView) findViewById(R.id.txttime);


        linearLayout = (LinearLayout) findViewById(R.id.filelinear);
    }


    public void changetheme() {
        SharedPreferences preferences = getSharedPreferences("theme", MODE_PRIVATE);
        int color = preferences.getInt("color", R.color.colorPrimary);
        lstfile.setBackgroundColor( getResources().getColor(color));
        linearLayout.setBackgroundColor( getResources().getColor(color));
    }


}
