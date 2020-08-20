package com.example.cammera;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
     ImageView imageview;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview=(ImageView)this.findViewById(R.id.imageView);
        Button phonebutton=(Button)this.findViewById(R.id.phnbtn);

        phonebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imagecapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(imagecapture,CAMERA_REQUEST);
            }
        });

    }

//    public void takePicture(View view)
//    {
//
//        if(imagecapture.resolveActivity(getPackageManager())!=null)
//        {
//
//        }
//    }

    protected void onActivityResult(int requestcode,int resultcode,Intent data)
    {
        super.onActivityResult(requestcode,requestcode,data);
        if(requestcode==CAMERA_REQUEST && resultcode == RESULT_OK)
        {
            //Bundle extras = data.getExtras();
            Bitmap imagebitmap = (Bitmap)data.getExtras().get("DATA");
            imageview.setImageBitmap(imagebitmap);
        }

    }
}