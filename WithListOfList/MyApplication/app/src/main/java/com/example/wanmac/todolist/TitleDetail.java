package com.example.wanmac.todolist;

import java.util.ArrayList;

/**
 * Created by wanmac on 7/7/16.
 */
public class TitleDetail {
    String mListName;
    ArrayList<IndiTitleDetail> bothTitlesDetails;

    TitleDetail(String listName) {
        mListName = listName;
        bothTitlesDetails = new ArrayList<IndiTitleDetail>();
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

    public String getListName() {
        return mListName;
    }

    public int getSize() {
        return bothTitlesDetails.size();
    }
}
