package com.example.android.messinatour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class EventFragment extends Fragment {

    Activity context;
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public String mParam1;
    public String mParam2;

    public EventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context=getActivity();
        //Create ArrayList of events
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        final ArrayList<EventList> event= new ArrayList<EventList>();
        //Add element to ArrayList
        event.add(new EventList(getString(R.string.vara), getString(R.string.info_vara), R.drawable.vara));
        event.add(new EventList(getString(R.string.fireworks), getString(R.string.info_fireworks), R.drawable.pirotecnico));
        ListView listView = (ListView) view.findViewById(R.id.listview_event);
        EventAdapter adapter = new EventAdapter(getContext(), event);
        //Create Adapter for custom class
        listView.setAdapter(adapter);
        //set event for element of list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, InfoPointActivity.class);
                EventList selectitem = event.get(position);
                //save variable for next step
                intent.putExtra("Name_id", selectitem.getName());
                intent.putExtra("Info_id", selectitem.getInfo());
                Bundle bundle = new Bundle();
                bundle.putInt("Image_id",selectitem.getImageResourceId());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;
    }

}
