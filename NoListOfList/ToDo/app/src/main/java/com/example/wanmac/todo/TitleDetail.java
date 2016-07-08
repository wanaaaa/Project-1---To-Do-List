package com.example.wanmac.todo;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by wanmac on 7/6/16.
 */
public class TitleDetail {
    private static TitleDetail titleDetail = null;
    private static ArrayList<IndiTitleDetail> bothTitlesDetails;


    private TitleDetail() {
        bothTitlesDetails = new ArrayList<IndiTitleDetail>();
    }

    public static TitleDetail getInstance() {
        if (titleDetail == null) {
            titleDetail = new TitleDetail();
        }
        return titleDetail;
    }

    public void addTileDetail(IndiTitleDetail instance){
        bothTitlesDetails.add(instance);
    }

    public void removeTitleDetail(int i) {
        bothTitlesDetails.remove(i);
    }

    public void removeAll() {
        bothTitlesDetails.clear();
    }

    public ArrayList<IndiTitleDetail> getTitlesDetails() {
        return bothTitlesDetails;
    }


}


