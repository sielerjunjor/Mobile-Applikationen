package com.example.marco.pvl.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.marco.pvl.R;

public class activitySave extends AppCompatActivity {

    Button btn_sumbmit;
    TextView txt_1;
    TextView txt_2;
    EditText editText;
    SharedPreferences prefs;
    String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_sumbmit = findViewById(R.id.button4);
        txt_1 = findViewById(R.id.textView9);
        txt_2 = findViewById(R.id.textView10);
        editText = findViewById(R.id.editText);

        prefs = this.getSharedPreferences("save", Context.MODE_PRIVATE);

        try {
            txt_1.setText(prefs.getString(KEY, new String()));
        }catch (Exception e){
            System.out.println("ERRRRORRRR"+e.toString());
}

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        btn_sumbmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  i = editText.getText().toString();
                txt_1.setText(i);
                txt_2.setText(i);
                prefs.edit().putString(KEY, i).commit();
                System.out.println("test"+prefs.getString(KEY,new String()));
            }
        });

    }

}
