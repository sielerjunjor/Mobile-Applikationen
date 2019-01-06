package com.example.marco.pvl.activities;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.widget.TextView;


import com.example.marco.pvl.R;

import java.util.ArrayList;

public class activityContact_Date extends AppCompatActivity {

   TextView tv;

    private static final int
            PERMISSIONS_REQUEST_READ_CONTACTS = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__date);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv = (TextView) findViewById(R.id.textView4);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (checkSelfPermission(Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]
                            {Manifest.permission.READ_CONTACTS},
                    PERMISSIONS_REQUEST_READ_CONTACTS);
        } else {
            doIt();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[],
                                           int[] grantResults) {
        if ((requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) &&
                (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED)) {
            doIt();
        }
    }

    private void doIt() {
        ContentResolver contentResolver = getContentResolver();
        // IDs und Namen aller sichtbaren Kontakte ermitteln
        String[] mainQueryProjection = {
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME};
        String mainQuerySelection =
                ContactsContract.Contacts.IN_VISIBLE_GROUP
                        + " = ?";
        String[] mainQuerySelectionArgs = new String[]{"1"};
        Cursor mainQueryCursor = contentResolver.query(
                ContactsContract.Contacts.CONTENT_URI,
                mainQueryProjection,
                mainQuerySelection,
                mainQuerySelectionArgs, null);

        if (mainQueryCursor != null) {
            while (mainQueryCursor.moveToNext()) {
                String displayName = mainQueryCursor.getString(1);
                tv.append("-> " + displayName + "\n");
            }
            mainQueryCursor.close();
        }
    }



    }


