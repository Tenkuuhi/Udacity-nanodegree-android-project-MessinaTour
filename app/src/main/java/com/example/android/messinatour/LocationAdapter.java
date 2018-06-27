package com.example.android.messinatour;

/**
 * Created by Tenkuuhi on 15/03/2018.
 */

import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<LocationList> {

    public LocationAdapter(Context context, ArrayList<LocationList> location) {

        super(context, 0, location);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.location_layout, parent, false);
        }
        // Get the {@link Location} object located at this position in the list
        LocationList currentLocation = getItem(position);
        // Find the TextView in the location_layout.xml layout with the ID text_name_event.
        TextView NameTextView = (TextView) listItemView.findViewById(R.id.text_name_location);
        // Get the Name point from the currentlocation object and set this text on
        NameTextView.setText(currentLocation.getName());
        // Return the whole location_layout so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
