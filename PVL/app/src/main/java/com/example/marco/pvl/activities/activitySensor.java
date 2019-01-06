package com.example.marco.pvl.activities;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.marco.pvl.R;

import java.util.List;

public class activitySensor extends AppCompatActivity {


    private SensorManager sMgr;
    Sensor selectedS;
    TextView sensorDetails;
    TextView sensorListValue;
    TextView text;
    Button btn_send;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        btn_send = findViewById(R.id.button);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        sensorDetails = this.findViewById(R.id.textView2);
        final RadioGroup dynSensors = this.findViewById(R.id.groupRadio);
        sMgr = (SensorManager)this.getSystemService(SENSOR_SERVICE);
        final List<Sensor> deviceSensors = sMgr.getSensorList(Sensor.TYPE_ALL);
        String sensorText = "";
        int y = 0;
        for(Sensor x:deviceSensors){
            RadioButton rbn = new RadioButton(this.getApplicationContext());
            rbn.setId(y);
            rbn.setText(x.getName());
            dynSensors.addView(rbn);
            y++;
        }
        dynSensors.setOrientation(LinearLayout.VERTICAL);

        //TODO How To -open form onCreate?
/*
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), activitySave.class);
                startActivity(i);
            }
        });
*/
    }

}
