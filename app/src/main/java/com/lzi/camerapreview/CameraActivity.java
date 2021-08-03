package com.lzi.camerapreview;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

public class CameraActivity extends Activity {
    private Camera camera;
    private CameraPreview cameraPreview;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camera = getCameraInstance();
        cameraPreview = new CameraPreview(this, camera);
        FrameLayout preview = findViewById(R.id.camera_preview);
        preview.addView(cameraPreview);

    }
    public static Camera getCameraInstance(){
        Camera camera = null;
        try {
            camera = Camera.open();
        }catch (Exception e){
            Log.i("MainActivity", e.getMessage());
        }
        return camera;
    }
}
