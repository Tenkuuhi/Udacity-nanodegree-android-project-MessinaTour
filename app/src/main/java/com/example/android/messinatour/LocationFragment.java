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

public class LocationFragment extends Fragment {

    Activity context;
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public String mParam1;
    public String mParam2;

    public LocationFragment() {
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
        //Create ArrayList of location
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        final ArrayList<LocationList> location= new ArrayList<LocationList>();
        //Add element to ArrayList
        location.add(new LocationList(getString(R.string.duomo), getString(R.string.info_duomo), R.drawable.duomo));
        location.add(new LocationList(getString(R.string.piazza_cairoli), getString(R.string.info_piazza_cairoli), R.drawable.piazza_cairoli));
        ListView listView = (ListView) view.findViewById(R.id.listview_location);
        LocationAdapter adapter = new LocationAdapter(getContext(), location);
        listView.setAdapter(adapter);
        //set event for element of list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, InfoPointActivity.class);
                LocationList selectitem = location.get(position);
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
