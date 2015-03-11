package com.example.joe.application_flickr_viewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class TopLocations extends Activity {

private ListView listLocations;
private List<TopLocationsObject> topLocations;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top__locations);

        listLocations = (ListView) findViewById(R.id.listLocations);

        topLocations = new ArrayList<TopLocationsObject>();

        topLocations.add(new TopLocationsObject("London","England",R.drawable.england,"http://upload.wikimedia.org/wikipedia/commons/3/3a/London_from_a_hot_air_balloon.jpg"));
        topLocations.add(new TopLocationsObject("Paris","France",R.drawable.france,"http://upload.wikimedia.org/wikipedia/commons/a/a8/Tour_Eiffel_Wikimedia_Commons.jpg"));
        topLocations.add(new TopLocationsObject("Berlin","Germany",R.drawable.germany,"http://upload.wikimedia.org/wikipedia/commons/8/83/Berlin_-_Siegessaeule_Aussicht_10-13_img4_Tiergarten_%28cropped%29.jpg"));
        topLocations.add(new TopLocationsObject("Madrid","Spain",R.drawable.spain,"http://upload.wikimedia.org/wikipedia/commons/4/4e/Monumento_a_Alfonso_XII_de_España_en_los_Jardines_del_Retiro_-_04.jpg"));
        topLocations.add(new TopLocationsObject("Rome","Italy",R.drawable.italy,"http://upload.wikimedia.org/wikipedia/commons/a/ab/Colosseo_di_Roma_panoramic.jpg"));
        topLocations.add(new TopLocationsObject("Dublin","Ireland",R.drawable.ireland,"http://upload.wikimedia.org/wikipedia/commons/c/c1/The_Samuel_Beckett_Bridge.jpg"));
        topLocations.add(new TopLocationsObject("Brussels","Belgium",R.drawable.belgium,"http://upload.wikimedia.org/wikipedia/commons/9/91/Brussels_floral_carpet_B.jpg"));
        topLocations.add(new TopLocationsObject("Copenhagen","Denmark",R.drawable.denmark,"http://upload.wikimedia.org/wikipedia/commons/7/7c/Christiansborg_Slot_Copenhagen_2014_01.jpg"));
        topLocations.add(new TopLocationsObject("Athens","Greece",R.drawable.greece,"http://upload.wikimedia.org/wikipedia/commons/c/c6/Attica_06-13_Athens_50_View_from_Philopappos_-_Acropolis_Hill.jpg"));
        topLocations.add(new TopLocationsObject("Amsterdam","Netherlands",R.drawable.netherlands,"http://upload.wikimedia.org/wikipedia/commons/b/be/KeizersgrachtReguliersgrachtAmsterdam.jpg"));

        LocationAdapter adapter = new LocationAdapter(topLocations);
        listLocations.setAdapter(adapter);

        listLocations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(TopLocations.this, SpecificLocationActivity.class);

                i.putExtra("EXTRA_TOP_LOCATION", topLocations.get(position));

                startActivity(i);
            }
        });

    }

    private class LocationAdapter extends ArrayAdapter<TopLocationsObject> {

        public LocationAdapter(List<TopLocationsObject> items) {
            super(TopLocations.this, 0, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(
                        R.layout.location_list, null);
            }

            ImageView imgFlag = (ImageView)convertView.findViewById(R.id.imgFlag);
            TextView lblCity = (TextView)convertView.findViewById(R.id.lblCity);
            TextView lblCountry = (TextView)convertView.findViewById(R.id.lblCountry);

            TopLocationsObject location = topLocations.get(position);

            imgFlag.setImageResource(location.getFlagResource());
            lblCity.setText(location.getCityName());
            lblCountry.setText(location.getCountryName());

            return convertView;

        }// end get view

    }// end adapter class

}
