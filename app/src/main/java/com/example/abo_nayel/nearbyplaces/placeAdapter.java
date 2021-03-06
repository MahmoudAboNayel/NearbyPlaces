package com.example.abo_nayel.nearbyplaces;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by Abo-Nayel on 24/10/2017.
 */

public class placeAdapter extends ArrayAdapter {
    public placeAdapter(@NonNull Context context, @NonNull PlaceModel[] objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_place_raw, parent, false);
        }
        PlaceModel placeModel = (PlaceModel) getItem(position);
        TextView name =(TextView) convertView.findViewById(R.id.Pname);
        TextView type = (TextView)convertView.findViewById(R.id.type);
        //RatingBar r = (RatingBar) convertView.findViewById(R.id.ratingBar);
        ImageView i = (ImageView) convertView.findViewById(R.id.photo);
        Picasso.with(getContext()).load("https://maps.googleapis.com/maps/api/place/photo?maxwidth=40&photoreference="+
                placeModel.photos[0].getPhoto_reference()+"&key=AIzaSyDi9JdUYE28KGzwm5t-dLONa4zIaVne6jc").into(i);
//        Toast.makeText(getContext(),placeModel.photos[0].getPhoto_reference(),Toast.LENGTH_SHORT).show();
//        r.setIsIndicator(true);
//        r.setRating(placeModel.getRating());
        type.setText(placeModel.getTypes()[1]);
        name.setText(placeModel.getName());
        return convertView;
    }
}

