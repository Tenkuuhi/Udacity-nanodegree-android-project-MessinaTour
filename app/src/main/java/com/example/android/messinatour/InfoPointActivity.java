package com.example.android.messinatour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

//class that set information of page info of point
public class InfoPointActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infopoint);
        Bundle bundle=this.getIntent().getExtras();
        //get value previously stored
        String Name = getIntent().getStringExtra("Name_id");
        String Info = getIntent().getStringExtra("Info_id");
        int Image=bundle.getInt("Image_id");
        //get elements id of InfoPointActivity.xml
        TextView pointName = (TextView) findViewById(R.id.title_point);
        TextView pointInfo = (TextView) findViewById(R.id.description_point);
        ImageView imagepoint = (ImageView) findViewById(R.id.image_point);
        //set element value of InfoPointActivity.xml
        pointName.setText(Name);
        pointInfo.setText(Info);
        imagepoint.setImageResource(Image);

    }
}
