package com.learn.wiratmoko11.movieapps;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        //Fake Data
        //ArrayList<String> dummyData = createDummyData();
        ArrayList<Integer> dummy = new ArrayList<>();
        dummy.add(R.drawable.image1);
        //Membuat Adapter
        //ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.list_item_forecast, R.id.list_item_forecast_cover, dummy);


        GridView gridView = (GridView) rootView.findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(getActivity(), mThumbIds));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity(), "Intent On", Toast.LENGTH_SHORT).show();
                Integer imageCover = mThumbIds[position];
                Intent intent = new Intent(getActivity(), DetailActivity.class).putExtra("image_location", imageCover);
                startActivity(intent);
            }
        });

        return rootView;
    }

    public ArrayList<String> createDummyData(){
        ArrayList<String> dummyData = new ArrayList<>();
        dummyData.add(Integer.toString(R.drawable.image1));

        return dummyData;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.movie1, R.drawable.movie2,
            R.drawable.movie2, R.drawable.movie1,
            R.drawable.movie1, R.drawable.movie2,
            R.drawable.movie2, R.drawable.movie1

    };

}
