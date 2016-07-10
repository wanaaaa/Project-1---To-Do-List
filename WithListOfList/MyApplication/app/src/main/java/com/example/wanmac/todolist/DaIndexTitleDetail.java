package com.example.wanmac.todolist;

/**
 * Created by lenoubun16 on 7/10/16.
 */
public class DaIndexTitleDetail {
    private static DaIndexTitleDetail indexTitleDetail = null;
    private static int mIndexTD;

    private DaIndexTitleDetail() {mIndexTD = -1;
    }

    static DaIndexTitleDetail getInstance() {
        if (indexTitleDetail == null) {
            indexTitleDetail = new DaIndexTitleDetail();
        }

        return indexTitleDetail;
    }

    static int getIndexTD() {
        return mIndexTD;
    }

    static void setIndexTD(int index){
        mIndexTD = index;
    }

}

//    private static DaListOfList listOfList = null;
//    private static ArrayList<TitleDetail> nameTitleDetail;
//
//    private DaListOfList() {
//        nameTitleDetail = new ArrayList<TitleDetail>();
//    }
//
//    static DaListOfList getInstance() {
//        if (listOfList == null) {
//            listOfList = new DaListOfList();
//        }
//        return  listOfList;
//    }