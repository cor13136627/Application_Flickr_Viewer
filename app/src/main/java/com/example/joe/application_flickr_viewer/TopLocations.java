package com.example.joe.application_flickr_viewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

        topLocations.add(new TopLocationsObject("London","England",R.drawable.england));
        topLocations.add(new TopLocationsObject("Paris","France",R.drawable.france));
        topLocations.add(new TopLocationsObject("Berlin","Germany",R.drawable.germany));
        topLocations.add(new TopLocationsObject("Madrid","Spain",R.drawable.spain));
        topLocations.add(new TopLocationsObject("Rome","Italy",R.drawable.italy));
        topLocations.add(new TopLocationsObject("Dublin","Ireland",R.drawable.ireland));
        topLocations.add(new TopLocationsObject("Brussels","Belgium",R.drawable.belgium));
        topLocations.add(new TopLocationsObject("Copenhagen","Denmark",R.drawable.denmark));
        topLocations.add(new TopLocationsObject("Athens","Greece",R.drawable.greece));
        topLocations.add(new TopLocationsObject("Amsterdam","Netherlands",R.drawable.netherlands));

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
