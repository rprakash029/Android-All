package com.example.androidall.broadcast_reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by DELL PC on 7/14/2016.
 */
public class MyBroadcastReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub

        // Extract data included in the Intent
        CharSequence intentData = intent.getCharSequenceExtra("message");
        Toast.makeText(context, "received the Intent's message: " + intentData, Toast.LENGTH_LONG).show();
    }

}
