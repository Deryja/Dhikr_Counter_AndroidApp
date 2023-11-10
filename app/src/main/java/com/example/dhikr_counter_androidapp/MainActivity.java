package com.example.dhikr_counter_androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonDhikr;
    private TextView AntallDhikr;

    int ØkerMed1 = 0;


    private Button resetDhikr;


    // Declare a ToneGenerator object
    ToneGenerator toneGenerator;

    private Switch switchSound;
    // Declaring a boolean variable to track sound status
    boolean isSoundEnabled = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toneGenerator = new ToneGenerator(AudioManager.STREAM_SYSTEM, 100); // Can be adjusted as needed



buttonDhikr = findViewById(R.id.dhikr);
AntallDhikr = findViewById(R.id.AntallDhikr);

resetDhikr = findViewById(R.id.reset);



switchSound = findViewById(R.id.sound);//Switch button for enabling/disabling sound


        //Made a logic for the button that when it is checked, it is true, and when it is unchecked it is false
     switchSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

isSoundEnabled = isChecked;

         }
     });



        buttonDhikr.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


if (isSoundEnabled == true){

    toneGenerator.startTone(ToneGenerator.TONE_CDMA_KEYPAD_VOLUME_KEY_LITE); //Makes the tone sound when the button is clicked
    ØkerMed1++; //Teller antall ganger knappen blir trukket på
    AntallDhikr.setText(String.valueOf(ØkerMed1)); //Displayer variabelen "ØkerMed1"

}
else{
    ØkerMed1++; //Teller antall ganger knappen blir trukket på
    AntallDhikr.setText(String.valueOf(ØkerMed1)); //Displayer variabelen "ØkerMed1"

}

       }




        });






        resetDhikr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    ØkerMed1 = 0;
                   AntallDhikr.setText(String.valueOf(ØkerMed1));
                }


        });



    }

    //Releases the tone generator when I'm done (onDestroy or onStop)
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (toneGenerator != null) {
            toneGenerator.release();
            toneGenerator = null;
        }


    }



}