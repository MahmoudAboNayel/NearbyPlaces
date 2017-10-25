package com.example.abo_nayel.nearbyplaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Search extends AppCompatActivity {

    String[] types = {
            "accounting",
            "airport",
            "amusement_park",
            "aquarium",
            "art_gallery",
            "atm",
            "bakery",
            "bank",
            "bar",
            "beauty_salon",
            "bicycle_store",
            "book_store",
            "bowling_alley",
            "bus_station",
            "cafe",
            "restaurant"
    };
    ListView places;
    EditText searchtxt;
    Button searchbtn;
    TextView t1,t2;
     PlaceModel[] placeModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        places = (ListView)findViewById(R.id.searchList);
        searchtxt = (EditText)findViewById(R.id.searchtxt);
        searchbtn =(Button)findViewById(R.id.searchbtn);
        t1 = (TextView)findViewById(R.id.textView2) ;
        t2 = (TextView)findViewById(R.id.textView6) ;
//        places.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(Search.this,placeModels[position].getName(),Toast.LENGTH_LONG).show();
//            }
//        });
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText("Nearby Places");
                String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&type="+
                        searchtxt.getText()+"&keyword=cruise&key=AIzaSyDi9JdUYE28KGzwm5t-dLONa4zIaVne6jc";
                excuteWebServices(url);
            }
        });
    }
    void excuteWebServices(String url){
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");

                    placeModels = new Gson().fromJson(jsonArray.toString(),PlaceModel[].class);
                    placeAdapter placeAdapter = new placeAdapter(Search.this,placeModels);
                    places.setAdapter(placeAdapter);
                    places.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(Search.this,placeModels[position].getName(),Toast.LENGTH_LONG).show();
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);
    }
}
