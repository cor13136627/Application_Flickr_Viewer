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
private List<String> cities;
private List<String> countries;
private List<Integer> flags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top__locations);

        listLocations = (ListView) findViewById(R.id.listLocations);

        cities = new ArrayList<>();
        cities.add("London");
        cities.add("Paris");
        cities.add("Berlin");
        cities.add("Madrid");
        cities.add("Rome");
        cities.add("Dublin");
        cities.add("Brussels");
        cities.add("Copenhagen");
        cities.add("Athens");
        cities.add("Amsterdam");

        countries = new ArrayList<>();
        countries.add("England");
        countries.add("France");
        countries.add("Germany");
        countries.add("Spain");
        countries.add("Italy");
        countries.add("Ireland");
        countries.add("Belgium");
        countries.add("Denmark");
        countries.add("Greece");
        countries.add("Netherlands");

        flags = new ArrayList<>();
        flags.add(R.drawable.england);
        flags.add(R.drawable.france);
        flags.add(R.drawable.germany);
        flags.add(R.drawable.spain);
        flags.add(R.drawable.italy);
        flags.add(R.drawable.ireland);
        flags.add(R.drawable.belgium);
        flags.add(R.drawable.denmark);
        flags.add(R.drawable.greece);
        flags.add(R.drawable.netherlands);

        LocationAdapter adapter = new LocationAdapter(cities);

        listLocations.setAdapter(adapter);

    }

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

            ImageView imgFlag = (ImageView)convertView.findViewById(R.id.imgFlag);
            TextView lblCity = (TextView)convertView.findViewById(R.id.lblCity);
            TextView lblCountry = (TextView)convertView.findViewById(R.id.lblCountry);

            String city = cities.get(position);
            String country = countries.get(position);
            int flag = flags.get(position);

            lblCity.setText(city);
            lblCountry.setText(country);
            imgFlag.setImageResource(flag);
            return convertView;

        }// end get view

    }// end adapter class

}
