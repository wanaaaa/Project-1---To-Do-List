package com.example.wanmac.todolist;

/**
 * Created by wanmac on 7/7/16.
 */
public class IndiTitleDetail {
    String mTitle, mDetail;

    public IndiTitleDetail() {
        mTitle = "title in IndiTitleDetail";
        mDetail = "detail in IndiTitleDetail";
    }

    public IndiTitleDetail(String title, String detail){
        mTitle = title;
        mDetail = detail;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDetail() {
        return mDetail;
    }

    public void setmTitle(String title) {
        mTitle = title;
    }

    public void setmDetail(String detail){
        mDetail = detail;
    }
}
