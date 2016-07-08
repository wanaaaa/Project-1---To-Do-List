package com.example.wanmac.todo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    TitleDetail titleDetail = TitleDetail.getInstance();


    private static final int anyRequest = 1;

    EditText mEditTextTitle, mEditTextDetail;
    TextView mTextViewTitle, mTextViewDetail;


    ArrayAdapter<String> mAdapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewTitle = (TextView) findViewById(R.id.title01);
        mTextViewDetail = (TextView) findViewById(R.id.detail01);

        Button buttonInput, buttonDetail;
        buttonInput = (Button) findViewById(R.id.inPutButton01);
        buttonDetail = (Button) findViewById(R.id.toDetaiButton01);


//
        buttonInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditTextTitle = (EditText)findViewById(R.id.title01) ;
                mEditTextDetail = (EditText)findViewById(R.id.detail01);
                String TitleString = mEditTextTitle.getText().toString();
                String DetailString = mEditTextDetail.getText().toString();

                if (TitleString.equals("") || DetailString.equals("")) {
                    Toast.makeText(getApplicationContext(), "The ToDo is empty " , Toast.LENGTH_SHORT).show();
                }

                IndiTitleDetail indiTitleDetail = new IndiTitleDetail();

                indiTitleDetail.setmTitle(TitleString);
                indiTitleDetail.setmDetail(DetailString);
                titleDetail.addTileDetail(indiTitleDetail);

                Toast.makeText(getApplicationContext(), "Saving the ToDo ..."+TitleString , Toast.LENGTH_SHORT).show();
            }
        });

        buttonDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, Detail.class), anyRequest);
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
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.wanmac.todo/http/host/path")
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
                Uri.parse("android-app://com.example.wanmac.todo/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
