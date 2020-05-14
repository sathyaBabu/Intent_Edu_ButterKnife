package com.app.intent_edu_butterknife;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import butterknife.BindArray;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

// 4  add impliments to over ride the onClick button
public class MainActivity extends AppCompatActivity { // implements View.OnClickListener {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @BindView(R.id.imageDisplay)  ImageView imageView;
    @BindView(R.id.textView)      TextView myTextView;
    @BindView(R.id.editTextName)  EditText editTextName ;

    @BindArray(R.array.myArray)    String[] names;
    @BindString(R.string.app_name) String appName ;

    @BindColor(R.color.colorAccent)      int pinkColor;
    @BindColor(R.color.colorPrimaryDark) int darkBlue;







//    @BindView(R.string.hello)
//    EditText myhello;



//    @BindArray(R.string.)

    // 1. declare all Button edit and view objects here..

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        // long running task....

        myTextView.setText("Butter Knife A Breather...."+appName+" name 0 "+names[ 0 ]);
        myTextView.setTextColor(pinkColor);



    }

    @OnClick(R.id.dialButton)
    public  void Mydialer( Button button){


        Toast.makeText(this, "Clicked on dialer......", Toast.LENGTH_SHORT).show();
    }



    @OnClick(R.id.viaPackageManager)
    public void ViaPackageManager(Button button) {

        PackageManager packageManager = getPackageManager();
        Intent intent= new Intent("code.anint.edu.com.intentedu.demoActivity");
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent,PackageManager.MATCH_DEFAULT_ONLY);

        boolean isIntentSafe = activities.size() > 0;

        if( isIntentSafe) {

            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Sorry PM : Activity not found in Package manager..", Toast.LENGTH_SHORT).show();
        }

        // crash the app
    }
    @OnClick(R.id.letsgetpro)
    public void LetsGetPro(Button button) {
    }
    @OnClick(R.id.viewIntent)
    public void ViewIntent(Button button) {

        // What kind of a componant we are going to create ?????
        // A video Streamer... ????
        // An Audio codec ...???
        // A remote printer...  HP

        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("mystreamer:"+"Play the Song from Streamer...\n"));
        intent.putExtra("From","\n This is from Sathya..");
        // startActivity(intent);
        startActivityForResult(intent, 222);

    }

    @OnClick(R.id.openWebPage)
    public void OpenWebPage(Button button) {

        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.com"));
        startActivity(intent);


    }
    @OnClick(R.id.showLocation)
    public void ShowLocation(Button button) {

        Intent showLocationIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:12.9986964,77.5898373"));
        startActivity(showLocationIntent);
    }
    @OnClick(R.id.toast)
    public void Toasta(Button button) {

        //Intent intent = new Intent(this,otherActivityEdureka.class);
        myTextView.setText("Butter Knife A Breather...."+editTextName.getText().toString());
        myTextView.setTextColor(darkBlue);

//        Intent intent = new Intent("code.anint.edu.com.intentedu.otherActivityEdureka");
//        startActivity(intent);
        // Intent intent = new Intent("Vivan");

        // Intent intent = new Intent(Intent.ACTION_VIEW);
        // startActivity(intent);
    }
    //    @OnClick(R.id.dialButton)
//    public void DialButton(Button button) {
//
//        // componant..
//        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789") );
//        startActivity(dialIntent);
//
//    }
    @OnClick(R.id.takePhoto)
    public void dispatchTakePictureIntent(Button button) {

        // MEDIA INTENT...
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    // we are waiting for an event...



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("tag", "Back to main " + requestCode);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);

        }

    }


}     // MainActivity
