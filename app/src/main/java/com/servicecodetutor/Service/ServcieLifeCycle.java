package com.servicecodetutor.Service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.servicecodetutor.R;

public class ServcieLifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servcie_life_cycle);
        Log.e("onCreate","thread id = "+Thread.currentThread().getId());
    }


    public void view_click(View view) {
        switch (view.getId())
        {
            case R.id.startservice:
                startService(new Intent(getApplicationContext(),MyService.class));
                break;
        }
    }

}
