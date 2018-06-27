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

public class EventAdapter extends ArrayAdapter<EventList> {

    public EventAdapter(Context context, ArrayList<EventList> event) {

        super(context, 0, event);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.event_layout, parent, false);
        }
        // Get the {@link Event} object located at this position in the list
        EventList currentEvent = getItem(position);
        // Find the TextView in the event_layout.xml layout with the ID text_name_event.
        TextView NameTextView = (TextView) listItemView.findViewById(R.id.text_name_event);
        // Get the Name point from the currentevent object and set this text on
        NameTextView.setText(currentEvent.getName());
        // Return the whole event_layout so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
