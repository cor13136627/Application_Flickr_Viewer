package com.example.joe.application_flickr_viewer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class TopPhotographs extends Activity {

    private GridView gridView;

    private List<String> urls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top__photographs);

        gridView = (GridView)findViewById(R.id.gridView);

        urls = new ArrayList<String>();

        urls.add("#0099CC");
        urls.add("#9933CC");
        urls.add("#FF8800");
        urls.add("#CC0000");

        TopImageAdapter adapter = new TopImageAdapter(TopPhotographs.this);
        gridView.setAdapter(adapter);
    }

    private class TopImageAdapter extends BaseAdapter {
        private Context mContext;

        public TopImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return urls.size();
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {


            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.cell_photo, null);
            }


            return convertView;
        }//end get view


    }//end top image adapter

}
