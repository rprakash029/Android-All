package com.example.androidall.camera;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.SurfaceView;
import android.view.Window;

/**
 * Created by DELL PC on 7/14/2016.
 */
public class MyCamAppActivity extends AppCompatActivity {
    private int viewWidth;
    private int viewHeight;

    private static final boolean useHttpCamera = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        calculateDisplayDimensions();

        SurfaceView cameraPreview;
        if (useHttpCamera) {

            cameraPreview = new HttpCameraPreview(this, viewWidth, viewHeight);
        }

        else {

            cameraPreview = new SurfaceView(this);

        }

        setContentView(cameraPreview);

    }

    private void calculateDisplayDimensions() {

        Display display = getWindowManager().getDefaultDisplay();

        viewWidth = display.getWidth();

        viewHeight = display.getHeight();
    }

}
