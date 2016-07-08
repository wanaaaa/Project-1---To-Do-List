package com.example.wanmac.todolist;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by wanmac on 7/7/16.
 */
public class ListDetailActivity extends AppCompatActivity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    EditText mEditItemTitle,mEditItemDetail ;


    DaListOfList listOfList = DaListOfList.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);

        Button buSaveItem;
        buSaveItem = (Button) findViewById(R.id.toSaveButton01);

        int comingInt = getIntent().getIntExtra("position", -1);
        final TitleDetail titleDetail = listOfList.getTitleDetailInstance(comingInt);
        String listName = titleDetail.getListName();

        TextView setListName = (TextView) findViewById(R.id.listNameID) ;
        setListName.setText("The list name is  " + listName);

        Toast.makeText(getApplicationContext(), "The coming list title is///"+listName,
                Toast.LENGTH_SHORT).show();

        buSaveItem.setOnClickListener(new View.OnClickListener() {
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
