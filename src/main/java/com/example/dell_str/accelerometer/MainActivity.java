package com.example.dell_str.accelerometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    Sensor s;
    SensorManager sm;
    TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 =(TextView)findViewById(R.id.textView);
        t2 =(TextView)findViewById(R.id.textView2);
        t3 =(TextView)findViewById(R.id.textView3);


        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x =sensorEvent.values[0];
        float y =sensorEvent.values[1];
        float z =sensorEvent.values[2];
        t1.setText(Float.toString(x));
        t2.setText(Float.toString(y));
        t3.setText(Float.toString(z));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
