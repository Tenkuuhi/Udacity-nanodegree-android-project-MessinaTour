package com.example.android.messinatour;

/**
 * Created by Tenkuuhi on 13/03/2018.
 */

public class NightClubList {

    //string that contain nightclub name
    private String name;
    //string that contain info of nightclub
    private String info;
    //int that contain id of nightclub's image
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public String getName() {
        return this.name;
    }

    public String getInfo() {
        return this.info;
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


    public NightClubList(String name, String info, int imageResourceId) {

        this.name = name;
        this.info = info;
        mImageResourceId = imageResourceId;
    }
}
