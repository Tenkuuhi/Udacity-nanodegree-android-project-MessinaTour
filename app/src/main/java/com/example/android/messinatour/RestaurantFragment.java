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

public class RestaurantFragment extends Fragment {

    Activity context;
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public String mParam1;
    public String mParam2;

    public RestaurantFragment() {
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
        //Create ArrayList of restaurant
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);
        final ArrayList<RestaurantList> restaurant= new ArrayList<RestaurantList>();
        //Add element to ArrayList
        restaurant.add(new RestaurantList(getString(R.string.agostiniana), getString(R.string.info_agostiniana), R.drawable.agostiniana));
        restaurant.add(new RestaurantList(getString(R.string.terrazza), getString(R.string.info_terrazza), R.drawable.terrazza));
        ListView listView = (ListView) view.findViewById(R.id.listview_restaurant);
        RestaurantAdapter adapter = new RestaurantAdapter(getContext(), restaurant);
        listView.setAdapter(adapter);
        //set event for element of list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, InfoPointActivity.class);
                RestaurantList selectitem = restaurant.get(position);
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
