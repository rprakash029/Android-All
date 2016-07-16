package com.example.androidall.intent;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.androidall.R;

/**
 * Created by DELL PC on 7/14/2016.
 */
public class MySmsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_my);

        String output = null;
        TextView dataIntent = (TextView) findViewById(R.id.output_intent);

        // take the data and the extras of the intent
        Uri url = getIntent().getData();
        Bundle extras = getIntent().getExtras();

        output = url.toString();
        // if there are extras, add them to the output string
        if (extras != null) {
            output = output + " from " + extras.getString("from");
        }
        dataIntent.setText(output);
    }

}
