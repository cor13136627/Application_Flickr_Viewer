package com.example.joe.application_flickr_viewer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Top_Locations extends Activity {

    private ListView listLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top__locations);

        listLocations = (ListView) findViewById(R.id.listLocations);

    }

    private List<String> cities;
    private List<String> countries;
    private List<Integer> flags;

    LocationAdapter adapter = new LocationAdapter(cities);

    listLocations.setAdapter(adapter);

    private class LocationAdapter extends ArrayAdapter<String> {

        public LocationAdapter(List<String> items) {
            super(Top_Locations.this, 0, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(
                        R.layout.location_list, null);
            }

            cities = new ArrayList<String>();
            cities.add("Hong Kong");

            ImageView imgFlag = (ImageView)convertView.findViewById(R.id.imgFlag);
            TextView lblCity = (TextView)convertView.findViewById(R.id.lblCity);
            TextView lblCountry = (TextView)convertView.findViewById(R.id.lblCountry);

            String city = cities.get(position);


            return convertView;
        }// end get view

    }// end adapter class

}
