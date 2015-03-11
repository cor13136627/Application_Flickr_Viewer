package com.example.joe.application_flickr_viewer;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by JoeCory on 10/03/15.
 */
public class SpecificLocationActivity extends Activity {

    private TextView lblLocationTitle;
    private ImageView imgLocation;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specific_location_activity);

        lblLocationTitle = (TextView)findViewById(R.id.lblLocationTitle);

        TopLocationsObject location = (TopLocationsObject) getIntent().getSerializableExtra("EXTRA_TOP_LOCATION");

        lblLocationTitle.setText(location.getCityName());

        ImageView imgLocation = (ImageView)findViewById(R.id.imgLocation);

        Picasso.with(SpecificLocationActivity.this).load(location.getMapPictureURL()).into(imgLocation);


    }
}
