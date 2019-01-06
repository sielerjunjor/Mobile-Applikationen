package com.example.marco.pvl.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.marco.pvl.R;

public class activityGallery extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        button2 = findViewById(R.id.button2);
        button2.getBackground().setAlpha( 0 );  // where a : 0..255 : 0=transparent, 255=fully opaque

        button2.bringToFront();
        button2.setClickable(true);

        imageView1 = findViewById(R.id.imageView3);
        imageView2 = findViewById(R.id.imageView4);

        imageView2.setVisibility(View.INVISIBLE);
        imageView1.setVisibility(View.VISIBLE);

        imageView1.bringToFront();
        imageView1.setClickable(true);
        imageView2.setClickable(true);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });





        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeImage();


                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeImage();
                    }
                },10000);
             }
        });
    }


    public void changeImage(){
        if (imageView1.getVisibility() == View.VISIBLE) {
            imageView1.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);


        } else if (imageView2.getVisibility() == View.VISIBLE) {
            imageView2.setVisibility(View.INVISIBLE);
            imageView1.setVisibility(View.VISIBLE);
        }
    }
}
