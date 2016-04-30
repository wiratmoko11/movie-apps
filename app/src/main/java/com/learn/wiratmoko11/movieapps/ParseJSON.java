package com.learn.wiratmoko11.movieapps;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wiratmoko11 on 4/27/2016.
 */
public class ParseJSON {
    public String json;

    public final String JSON_ARRAY = "results";
    public final String KEY_POSTER = "poster_path";

    public String[] poster;

    private JSONArray movies = null;
    public ParseJSON(String json){
        this.json = json;
        Log.v("PANJANG", json);
    }

    protected void parseJSON(){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            movies = jsonObject.getJSONArray(JSON_ARRAY);

            poster = new String[movies.length()];

            for (int i = 0; i < movies.length(); i++) {
                JSONObject movie = movies.getJSONObject(i);
                poster[i] = "http://image.tmdb.org/t/p/w500/"+movie.getString(KEY_POSTER);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
