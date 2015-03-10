package com.example.joe.application_flickr_viewer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by JoeCory on 10/03/15.
 */
public class SpecificLocationActivity extends Activity {
    private TextView lblLocationTitle;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specific_location_activity);

        lblLocationTitle = (TextView)findViewById(R.id.lblLocationTitle);

        String cityName = getIntent().getStringExtra("EXTRA_CITY_NAME");

        lblLocationTitle.setText(cityName);

    }
}
