package com.example.android.messinatour;

/**
 * Created by Tenkuuhi on 13/03/2018.
 */

public class EventList {

    //string that contain event name
    private String name;
    //string that contain info of event
    private String info;
    //int that contain id of event's image
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    public EventList(String name, String info, int imageResourceId) {

        this.name = name;
        this.info = info;
        mImageResourceId = imageResourceId;
    }
}
