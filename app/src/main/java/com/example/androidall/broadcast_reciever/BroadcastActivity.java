package com.example.androidall.broadcast_reciever;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.example.androidall.R;

/**
 * Created by DELL PC on 7/14/2016.
 */
public class BroadcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
    }


    public void broadcastCustomIntent(View view)
    {
        Intent intent = new Intent("MyCustomIntent");

        EditText et = (EditText)findViewById(R.id.extraIntent);
        // add data to the Intent
        intent.putExtra("message", (CharSequence)et.getText().toString());
        intent.setAction("com.example.androidall.android.A_CUSTOM_INTENT");
        sendBroadcast(intent);
    }


}
