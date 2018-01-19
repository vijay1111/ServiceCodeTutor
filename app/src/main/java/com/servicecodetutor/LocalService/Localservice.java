package com.servicecodetutor.LocalService;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class Localservice extends Service {
    private int mRandomNumber;
    private boolean mIsRandomGeneratorOn;
    private final int MIN = 0;
    private final int MAX = 100;

    // this weill return the LocalService Instance
    class MyServiceBinder extends Binder {
        public Localservice getService() {
            return Localservice.this;
        }
    }

    private IBinder mBinder = new MyServiceBinder();

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("LocalService.java ", "In OnBind");
        return mBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopRandomNumberGenerator();
        Log.e("LocalService.java ", "Service Destroyed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("LocalService.java ", "In onStartCommend, thread id: " + Thread.currentThread().getId());
        mIsRandomGeneratorOn = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                startRandomNumberGenerator();
            }
        }).start();
        return START_STICKY;
    }

    private void startRandomNumberGenerator() {
        while (mIsRandomGeneratorOn) {
            try {
                Thread.sleep(1000);
                if (mIsRandomGeneratorOn) {
                    mRandomNumber = new Random().nextInt(MAX) + MIN;
                    Log.e("LocalService.java ", "Thread id: " + Thread.currentThread().getId() + ", Random Number: " + mRandomNumber);
                }
            } catch (InterruptedException e) {
                Log.e("LocalService.java ", "Thread Interrupted");
            }
        }
    }

    private void stopRandomNumberGenerator() {
        mIsRandomGeneratorOn = false;
    }
}