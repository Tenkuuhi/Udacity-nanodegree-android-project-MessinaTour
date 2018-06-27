package com.example.android.messinatour;

/**
 * Created by Tenkuuhi on 15/03/2018.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class RestaurantAdapter extends ArrayAdapter<RestaurantList> {

    public RestaurantAdapter(Context context, ArrayList<RestaurantList> event) {

        super(context, 0, event);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.restaurant_layout, parent, false);
        }
        // Get the {@link restaurant} object located at this position in the list
        RestaurantList currentRestaurant = getItem(position);
        // Find the TextView in the restaurant_layout.xml layout with the ID text_name_event.
        TextView NameTextView = (TextView) listItemView.findViewById(R.id.text_name_restaurant);
        // Get the Name point from the currentrestaurant object and set this text on
        NameTextView.setText(currentRestaurant.getName());
        //Return the whole restaurant_layout so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
