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

        topLocations.add(new TopLocationsObject("London","England",R.drawable.england,"http://www.chch.ox.ac.uk/sites/default/files/images/development/dev2014/CitySkyline.jpg","44418"));
        topLocations.add(new TopLocationsObject("Paris","France",R.drawable.france,"http://cache.graphicslib.viator.com/graphicslib/thumbs674x446/2050/SITours/eiffel-tower-paris-moulin-rouge-show-and-seine-river-cruise-in-paris-150305.jpg", "2"));
        topLocations.add(new TopLocationsObject("Berlin","Germany",R.drawable.germany,"http://www.telegraph.co.uk/travel/destination/article128328.ece/ALTERNATES/w620/berlin.jpg", "4"));
        topLocations.add(new TopLocationsObject("Madrid","Spain",R.drawable.spain,"http://anastasia.llobe.com/wp-content/uploads/2014/10/madrid4.jpg", "2"));
        topLocations.add(new TopLocationsObject("Rome","Italy",R.drawable.italy,"http://media-cdn.tripadvisor.com/media/photo-s/02/fb/39/1f/walks-inside-rome.jpg", "2"));
        topLocations.add(new TopLocationsObject("Dublin","Ireland",R.drawable.ireland,"http://media-cdn.tripadvisor.com/media/photo-s/03/9b/2d/c6/dublin.jpg", "2"));
        topLocations.add(new TopLocationsObject("Brussels","Belgium",R.drawable.belgium,"http://www.telegraph.co.uk/incoming/article59022.ece/ALTERNATES/w460/brussels620.jpg", "2"));
        topLocations.add(new TopLocationsObject("Copenhagen","Denmark",R.drawable.denmark,"http://cdni.condenast.co.uk/646x430/a_c/copenhagen_cnt_6nov09_istock_b.jpg", "2"));
        topLocations.add(new TopLocationsObject("Athens","Greece",R.drawable.greece,"http://downloads.bbc.co.uk/rmhttp/schools/primaryhistory/images/ancient_greeks/athens/g_acropolis.jpg", "2"));
        topLocations.add(new TopLocationsObject("Amsterdam","Netherlands",R.drawable.netherlands,"http://www.disfrutaamsterdam.com/fotos/amsterdam-atardecer.jpg", "2"));

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
