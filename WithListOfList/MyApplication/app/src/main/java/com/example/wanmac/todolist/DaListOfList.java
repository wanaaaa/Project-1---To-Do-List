package com.example.wanmac.todolist;

import java.util.ArrayList;

/**
 * Created by wanmac on 7/7/16.
 */
public class DaListOfList {

    private static DaListOfList listOfList = null;
    private static ArrayList<TitleDetail> nameTitleDetail;

    private DaListOfList() {
        nameTitleDetail = new ArrayList<TitleDetail>();
    }

    static DaListOfList getInstance() {
        if (listOfList == null) {
            listOfList = new DaListOfList();
        }
        return  listOfList;
    }

    public ArrayList<TitleDetail> getNameTitleDetail() {
        return nameTitleDetail;
    }

    public void addList(TitleDetail instance) {
        nameTitleDetail.add(instance);
    }

    public void removeList(int i){
        nameTitleDetail.remove(i);
    }

    public void removeAll() {
        nameTitleDetail.clear();
    }

    public int getSize() {
        return nameTitleDetail.size();
    }

    public TitleDetail getTitleDetailInstance(int i) {
        return nameTitleDetail.get(i);
    }
}
