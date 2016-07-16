package com.example.androidall.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidall.R;

/**
 * Created by DELL PC on 7/14/2016.
 */
public class IntentActivity extends AppCompatActivity {
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText) findViewById(R.id.recipient);

        // Use ACTION_SENDTO action with correct data
        Button sms1 = (Button) findViewById(R.id.sendto_sms);
        sms1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String uri = "smsto:" +  edit.getText().toString();
                Intent i = new Intent(android.content.Intent.ACTION_SENDTO,
                        Uri.parse(uri));
                startActivity(i);
            }
        });

        // Use our custom SMS_INTENT intent with correct data
        Button sms2 = (Button) findViewById(R.id.smsintent_sms);
        sms2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String uri = "smsto:" + edit.getText().toString();
                Intent i = new Intent("com.example.javacodegeeks.SMS_INTENT",
                        Uri.parse(uri));
                // put extra field
                i.putExtra("from", "javacodegeeks");
                startActivity(i);
            }
        });

        // Use our custom SMS_INTENT intent with incorrect data
        Button exception = (Button) findViewById(R.id.exception);
        exception.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String uri = "mailto:" + edit.getText().toString();
                Intent i = new Intent("com.example.javacodegeeks.SMS_INTENT",
                        Uri.parse(uri));
                i.putExtra("from", "javacodegeeks");
                startActivity(i);

            }
        });

    }

}
