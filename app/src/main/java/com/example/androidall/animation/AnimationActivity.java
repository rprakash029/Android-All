package com.example.androidall.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidall.R;

/**
 * Created by DELL PC on 7/14/2016.
 */
public class AnimationActivity extends AppCompatActivity {


    private Button fade;
    private Button zoom;
    private Button moveIntent;
    private Button rotate;
    private TextView mytext;
    private ImageView myimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        mytext = (TextView) findViewById(R.id.text);
        myimage = (ImageView) findViewById(R.id.image);

        fade = (Button) findViewById(R.id.fade);
        fade.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                fadeAnimation(v);
            }
        });

        zoom = (Button) findViewById(R.id.zoom);
        zoom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                zoomAnimation(v);
            }
        });

        moveIntent = (Button) findViewById(R.id.move);
        moveIntent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                moveAnimation(v);
            }
        });

        rotate = (Button) findViewById(R.id.rotate);
        rotate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                rotateAnimation(v);
            }
        });
    }

    private void fadeAnimation(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        mytext.startAnimation(animation);
    }

    private void zoomAnimation(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        myimage.startAnimation(animation);
    }

    private void rotateAnimation(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        myimage.startAnimation(animation);
    }

    private void moveAnimation(View view) {
        try{
            Intent intent = new Intent(this, MoveActivity.class);
            startActivity(intent);
        }catch(Exception e) {
            Toast.makeText(getApplicationContext(), "Error with the Intent",
                    Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


}
