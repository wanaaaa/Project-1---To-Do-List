package com.example.wanmac.todolist;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

/**
 * Created by wanmac on 7/7/16.
 */
public class ListDetailActivity extends AppCompatActivity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    final DaListOfList listOfList = DaListOfList.getInstance();
    RecyclerView mRecyclerView;
    AdpaterListDetail adapter;

    private GoogleApiClient client;

    EditText mEditItemTitle,mEditItemDetail ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview_ItemDetailList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        ///////////////////////
        FloatingActionButton fabSaveInDetal;
        fabSaveInDetal = (FloatingActionButton) findViewById(R.id.fabInDetail);


        final int comingInt = getIntent().getIntExtra("position", -1);

        final TitleDetail titleDetail = listOfList.getTitleDetailInstance(comingInt);

        DaIndexTitleDetail newInTD = DaIndexTitleDetail.getInstance();
        newInTD.setIndexTD(comingInt);
        //////////////////////////////////
        ArrayList<IndiTitleDetail> data = titleDetail.getTitlesDetails();

        adapter = new AdpaterListDetail(data);
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ///////////////////////////////////
        String listName = titleDetail.getListName();

        TextView setListName = (TextView) findViewById(R.id.listNameID) ;
        setListName.setText("The list name is  " + listName);

        Toast.makeText(getApplicationContext(), "The coming list title is///"+listName,
                Toast.LENGTH_SHORT).show();

        fabSaveInDetal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditItemTitle = (EditText)findViewById(R.id.itemTitle01);
                mEditItemDetail = (EditText) findViewById(R.id.itemDetail01);
                String titleStr = mEditItemTitle.getText().toString();
                String detailStr = mEditItemDetail.getText().toString();

                IndiTitleDetail indiTitleDetail = new IndiTitleDetail();
                indiTitleDetail.setmTitle(titleStr);
                indiTitleDetail.setmDetail(detailStr);

                titleDetail.addTileDetail(indiTitleDetail);

                adapter.notifyDataSetChanged();

                //Intent indexTitleDetail = new Intent(ListDetailActivity.this, AdpaterListDetail.class );
                //indexTitleDetail.putExtra("indexTitleDetail", comingInt);
                //ListDetailActivity.this.startActivity(indexTitleDetail);

                Toast.makeText(getApplicationContext(), "indiTitle///"+indiTitleDetail,
                        Toast.LENGTH_LONG).show();

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ListDetail Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.wanmac.todolist/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ListDetail Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.wanmac.todolist/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
