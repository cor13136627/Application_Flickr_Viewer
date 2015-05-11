package com.example.joe.application_flickr_viewer;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Joe on 5/10/2015.
 */
public interface FlickrService {

    @GET("/services/rest/?api_key=acbc91197494fa2a61d712552c0e9ad6&format=" +
            "json&safe_search=1" +
            "&content_type=1&extras=url_o&method=flickr.photos.search&nojsoncallback=1")
    void getPhotosForLocation(@Query("woe_id") String woe_id, Callback<FlickrResponse> cb);

}
