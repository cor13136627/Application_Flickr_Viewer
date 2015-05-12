package com.example.joe.application_flickr_viewer;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Downloader;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SpecificLocationActivity extends Activity implements Serializable {

    private TextView lblLocationTitle;
    private TopLocationsObject location;
    private List<FlickrResponse.FlickrPhotos.FlickrPhoto> photos;
    private GridView gridView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specific_location_activity);

        lblLocationTitle = (TextView)findViewById(R.id.lblLocationTitle);

        location = (TopLocationsObject) getIntent().getSerializableExtra("EXTRA_TOP_LOCATION");

        lblLocationTitle.setText(location.getCityName());

        ImageView imgLocation = (ImageView)findViewById(R.id.imgLocation);

        Picasso.with(SpecificLocationActivity.this).load(location.getMapPictureURL()).into(imgLocation);

        gridView = (GridView)findViewById(R.id.gridView);

        getDataFromFlickr();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent i = new Intent(SpecificLocationActivity.this, SinglePhoto.class);

                i.putExtra("URL", photos.get(position).getUrl_m());

                startActivity(i);

            }
        });

    }

    private void getDataFromFlickr() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.flickr.com")
                .build();

        FlickrService service = restAdapter.create(FlickrService.class);

        service.getPhotosForLocation(location.getWoeid() , new Callback<FlickrResponse>() {
            @Override
            public void success(FlickrResponse flickrResponse, Response response) {
                Log.d("JOE_FLICKR", "success");

                if (flickrResponse.getPhotos().getPhoto() != null &&
                        flickrResponse.getPhotos().getPhoto().size() > 0){

                    photos = flickrResponse.getPhotos().getPhoto();

                    PhotoAdapter adapter = new PhotoAdapter(SpecificLocationActivity.this);
                    gridView.setAdapter(adapter);

                }
            }//end on success

            @Override
            public void failure(RetrofitError retrofitError) {

                Log.d("JOE_FLICKR", retrofitError.getLocalizedMessage());

            }//end on failure

        }//end callbacks

        );//end get photos request
    }

        private class PhotoAdapter extends BaseAdapter {
            private Context mContext;

            public PhotoAdapter(Context c) {
                mContext = c;
            }

            public int getCount() {
                return photos.size();
            }

            public Object getItem(int position) {
                return null;
            }

            public long getItemId(int position) {
                return 0;
            }

            public View getView(int position, View convertView, ViewGroup parent) {


                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(
                            R.layout.cell_photo, null);
                }

                ImageView imgPhoto = (ImageView)convertView.findViewById(R.id.imgPhoto);

                if (photos.get(position) != null){


                    if (photos.get(position).getUrl_m() != null){

                        Picasso.with(SpecificLocationActivity.this).
                                load(photos.get(position).getUrl_m()).into(imgPhoto);
                    }
                }
                return convertView;
            }


        }
    }

