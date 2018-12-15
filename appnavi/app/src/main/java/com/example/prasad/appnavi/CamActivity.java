package com.example.prasad.appnavi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CamActivity  extends AppCompatActivity {

    ImageView imageView;
    private static final int CAMERA_REQUEST = 9999;
    Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cam_activity);
        imageView = (ImageView) findViewById(R.id.camimage);
        button =(Button) findViewById(R.id.capture);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent3, CAMERA_REQUEST);
            }
        });



    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
    }
}


