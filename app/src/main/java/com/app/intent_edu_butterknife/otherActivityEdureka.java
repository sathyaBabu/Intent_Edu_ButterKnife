package com.app.intent_edu_butterknife;


import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class otherActivityEdureka extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView; //


    @OnClick(R.id.button)
    public void callMyChildButton(Button button) {
        textView.setText("clicked on child buttton..");


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_other);

        ButterKnife.bind(this);
        Toast.makeText(this, "Landed In Other Activity Edureka( LOCAL )", Toast.LENGTH_SHORT).show();

        textView.setText("Landed In Other Activity Edureka( LOCAL )");
        String outPut = null;

        //TextView textView = ( TextView )findViewById(R.id.childView);

        // Streaming path

       // Uri uri = getIntent().getData();  // we are trying to retrive the tag: mystreamer:
                                          //  <data android:scheme="mystreamer"/>

//        Uri uriAction = Uri.parse(getIntent().getAction());
//        Uri uriCat    = Uri.parse(getIntent().getCategories());
//


        // extras..

//        Bundle extras = getIntent().getExtras(); // Lets get the data( String ) - streamer - codec
//
//        outPut = uri.toString();

//        if( extras != null ){
//            outPut = outPut + "From " + extras.getString("From");
//
//        }

       // textView.setText(outPut);
    }
}
