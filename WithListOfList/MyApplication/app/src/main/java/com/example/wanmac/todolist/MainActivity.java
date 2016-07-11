package com.example.wanmac.todolist;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecylerView;
    AdapterListOfList adapter;
    private static final int anyRequest = 1;

    DaListOfList newListOfList = DaListOfList.getInstance();

    EditText mEditListTitle;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecylerView = (RecyclerView) findViewById(R.id.recycleview_main) ;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this
                , LinearLayoutManager.VERTICAL,false);
        mRecylerView.setLayoutManager(linearLayoutManager);
        ///////////////////////////////////
        final DaListOfList new2ListOfList = DaListOfList.getInstance();
        ArrayList<TitleDetail> data = new2ListOfList.getNameTitleDetail();

        adapter = new AdapterListOfList(data);
        mRecylerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
        //////////////////////////////
        FloatingActionButton fabSaveInMain;
        Button buttonDeleteAll;

        buttonDeleteAll = (Button) findViewById(R.id.buListAll01) ;
        fabSaveInMain  = (FloatingActionButton) findViewById(R.id.fabInMain);

        fabSaveInMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditListTitle = (EditText) findViewById(R.id.title01);
                String listTitleStr = mEditListTitle.getText().toString();

                TitleDetail newTitieDetail = new TitleDetail(listTitleStr);
                newListOfList.addList(newTitieDetail);

                //String nname = newListOfList.getTitleDetailInstance(0).mListName;

                adapter.notifyDataSetChanged();

            }
        });

        buttonDeleteAll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DaListOfList listOfListDeleteAll = DaListOfList.getInstance();
                listOfListDeleteAll.removeAll();
                adapter.notifyDataSetChanged();
                //listOfListDeleteAll.notify();

            }
        });
        ///////////////////

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
                "Main Page", // TODO: Define a title for the content shown.
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
                "Main Page", // TODO: Define a title for the content shown.
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
