package com.example.joe.application_flickr_viewer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;




public class Top_Locations extends Activity {

    private ListView location_list;

    location_list=(ListView)findViewById(R.id.location_list);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top__locations);



    }




}
