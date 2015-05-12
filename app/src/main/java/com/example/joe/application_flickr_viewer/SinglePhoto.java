package com.example.joe.application_flickr_viewer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Joe on 5/12/2015.
 */



public class SinglePhoto extends Activity  {
    private ImageView SinglePhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_photo_activity);

        SinglePhoto = (ImageView)findViewById(R.id.singlePhoto);

        String photoURL = (String) getIntent().getStringExtra("URL");



        Picasso.with(SinglePhoto.this).load(photoURL).into(SinglePhoto);

    }
}
