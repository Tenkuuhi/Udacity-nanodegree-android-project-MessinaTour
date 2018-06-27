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

public class NightClubFragment extends Fragment {

    Activity context;
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public String mParam1;
    public String mParam2;

    public NightClubFragment() {
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
        //Create ArrayList of nightclub
        View view = inflater.inflate(R.layout.fragment_night_club, container, false);
        final ArrayList<NightClubList> nightclub= new ArrayList<NightClubList>();
        //Add element to ArrayList
        nightclub.add(new NightClubList(getString(R.string.mama), getString(R.string.info_mama), R.drawable.mama));
        nightclub.add(new NightClubList(getString(R.string.officina), getString(R.string.info_officina), R.drawable.officina));
        ListView listView = (ListView) view.findViewById(R.id.listview_nightclub);
        NightClubAdapter adapter = new NightClubAdapter(getContext(), nightclub);
        listView.setAdapter(adapter);
        //set event for element of list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, InfoPointActivity.class);
                NightClubList selectitem = nightclub.get(position);
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
