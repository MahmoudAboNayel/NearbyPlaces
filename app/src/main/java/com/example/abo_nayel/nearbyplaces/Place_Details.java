package com.example.abo_nayel.nearbyplaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Place_Details extends AppCompatActivity {

        ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place__details);
        im = (ImageView)findViewById(R.id.imageView);
        Picasso.with(getApplicationContext()).load("https://maps.googleapis.com/maps/api/staticmap?center=Brooklyn+Bridge,New+York" +
                ",NY&zoom=13&size=600x300&maptype=roadmap&markers=color:blue|label:S|40.702147,-74.015794&markers" +
                "=color:green|label:G|40.711614,-74.012318&markers=color:red|label:C|40.718217,-73.998284&keyAIzaS" +
                "yDi9JdUYE28KGzwm5t-dLONa4zIaVne6jc").into(im);
    }
}
