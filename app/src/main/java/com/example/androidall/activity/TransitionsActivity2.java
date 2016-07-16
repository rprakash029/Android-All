package com.example.androidall.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.example.androidall.R;

/**
 * Created by DELL PC on 7/14/2016.
 */
public class TransitionsActivity2 extends AppCompatActivity implements View.OnClickListener {

    Context context;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = TransitionsActivity2.this;
        setContentView(R.layout.activity_transition_2);
        initializeViews();
    }

    public void initializeViews() {
        FrameLayout fade_in_button = (FrameLayout) findViewById(R.id.fade_in);
        fade_in_button.setOnClickListener(this);

        FrameLayout fade_out_button = (FrameLayout) findViewById(R.id.fade_out);
        fade_out_button.setOnClickListener(this);

        FrameLayout slide_down_button = (FrameLayout) findViewById(R.id.slide_down);
        slide_down_button.setOnClickListener(this);

        FrameLayout slide_up_button = (FrameLayout) findViewById(R.id.slide_up);
        slide_up_button.setOnClickListener(this);

        FrameLayout slide_from_left_button = (FrameLayout) findViewById(R.id.slide_from_left);
        slide_from_left_button.setOnClickListener(this);

        FrameLayout slide_from_right_button = (FrameLayout) findViewById(R.id.slide_from_right);
        slide_from_right_button.setOnClickListener(this);
    }

    private void goToNextActivity(int animationIn, int animationOut) {
        Intent intent = new Intent(context, TransitionsActivity1.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        overridePendingTransition(animationIn, animationOut);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fade_in) {
            goToNextActivity(R.anim.fade_in, R.anim.fade_out);
        } else if (v.getId() == R.id.fade_out) {
            goToNextActivity(R.anim.fade_out, R.anim.fade_out);
        } else if (v.getId() == R.id.slide_down) {
            goToNextActivity(R.anim.slide_down, R.anim.fade_out);
        } else if (v.getId() == R.id.slide_up) {
            goToNextActivity(R.anim.slide_up, R.anim.fade_out);
        } else if (v.getId() == R.id.slide_from_left) {
            goToNextActivity(R.anim.slide_in_from_left, R.anim.fade_out);
        } else if (v.getId() == R.id.slide_from_right) {
            goToNextActivity(R.anim.slide_in_from_right, R.anim.fade_out);
        }
    }
}
