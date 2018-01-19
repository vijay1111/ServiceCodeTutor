package com.servicecodetutor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.servicecodetutor.LocalService.LocalServiceActivity;
import com.servicecodetutor.LocalServiceUsingIbinder.LocalServiceActivity1;
import com.servicecodetutor.RemoteServiceUsingMessenger.RemoteBindingActivity;
import com.servicecodetutor.Service.ServcieLifeCycle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void view_click(View view) {
        switch(view.getId())
        {
            case R.id.service_lifecycle:
                startActivity(new Intent(getApplicationContext(),ServcieLifeCycle.class));
                break;
            case R.id.localbinding:
                startActivity(new Intent(getApplicationContext(), LocalServiceActivity.class));
                break;

            case R.id.local_binding_usingIbinder:
                startActivity(new Intent(getApplicationContext(), LocalServiceActivity1.class));
                break;
            case R.id.remotebinding:
                startActivity(new Intent(getApplicationContext(),RemoteBindingActivity.class));
                break;

        }
    }

}
