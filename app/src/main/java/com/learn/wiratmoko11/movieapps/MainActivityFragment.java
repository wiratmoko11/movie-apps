package com.learn.wiratmoko11.movieapps;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    // references to our images

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        //

        fetchJson(rootView);


        return rootView;
    }

    public void showJSON(String json, View rootView) {
        ParseJSON parseJSON = new ParseJSON(json);
        parseJSON.parseJSON();

        GridView gridView = (GridView) rootView.findViewById(R.id.gridview);
        //Log.v("DATAPOSTER", parseJSON.poster.toString());
        gridView.setAdapter(new ImageAdapter(getActivity(), parseJSON.poster));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity(), "Intent On", Toast.LENGTH_SHORT).show();
                //Integer imageCover = mThumbIds[position];
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                startActivity(intent);
            }
        });
    }


    public void fetchJson(final View rootView) {
        // RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=4ea4a347228f2946727326301c313401";


        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJSON(response, rootView);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

//        JsonObjectRequest jsonReq = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                showJSON(response.getString());
//            }
//            ,
//                    new Response.ErrorListener()
//
//            {
//                @Override
//                public void onErrorResponse (VolleyError error){
//
//            }
//            }
//
//            );
//
//        }
            RequestQueue queue = Volley.newRequestQueue(getActivity());
            queue.add(stringRequest);
    }
}
