package com.example.video69;

import android.app.Application;
import android.content.Context;
import android.location.Address;
import android.os.Environment;
import android.os.Handler;

import java.io.File;

public class G extends Application {
   public static Context context;
   public  static String address;
   public static Handler handler=new Handler();



    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        address= Environment.getExternalStorageDirectory().getAbsolutePath()+"/VoiceRecorder/my_sounds";
        new File(address).mkdirs();
    }
}
