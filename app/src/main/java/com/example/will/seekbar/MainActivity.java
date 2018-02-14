package com.example.will.seekbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    //declare variables
    private static SeekBar seekBar;
    private static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar();
    }

    public void seekBar(){

        //global variables to seekBar class
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.textView);

        textView.setText("Covered : " + seekBar.getProgress() + " / " + seekBar.getMax());
        
        seekBar.setOnSeekBarChangeListener(

                new SeekBar.OnSeekBarChangeListener() {

                    int progressValue;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                        progressValue = progress;
                        textView.setText("Covered : " + progress + " / " + seekBar.getMax());
                        Toast.makeText(MainActivity.this, "Seek Bar in progress", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(MainActivity.this, "Seek Bar start tracking", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        textView.setText("Covered : " + progressValue + " / " + seekBar.getMax());
                        Toast.makeText(MainActivity.this, "Seek Bar stop tracking", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }


}
