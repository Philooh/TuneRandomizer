package com.tunerandomizer.philippe.tunerandomizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    List<String> listOfArtists = new ArrayList<String>();
    List<String> listOfTunes = new ArrayList<String>();
    int generatedNumber = 99999;

    // Declaring connection variables
    Connection con;
    String un,pass,db,ip;
    //End Declaring connection variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButtonsClickListener();
    }

    protected String doInBackground(String... params)
    {
        String returnedValue = null;
        return returnedValue;
    }

    //Method that is called when the user clicks the button
    public void randomizeGenerators(List<String> listRandom, String typeOfList){

        TextView textViewTune = (TextView) findViewById(R.id.tuneTxt);
        TextView textViewArtist = (TextView) findViewById(R.id.artistTxt);

        Random rand = new Random();
        int n = rand.nextInt(listRandom.size()-1);

        if(typeOfList == "Tunes"){

            List<String> temporaryTuneList = new ArrayList<String>();
            for(int i=0 ; i<listRandom.size()-1 ; i++){
                String tune = listRandom.get(i);

                if(tune.contains(textViewArtist.getText())){
                    temporaryTuneList.add(tune);
                }
            }
            listRandom = temporaryTuneList;
            n = rand.nextInt(listRandom.size()-1);
        }


        while(generatedNumber == n){
            n = rand.nextInt(listRandom.size()-1);
        }

        generatedNumber = n;
        String string = listRandom.get(n);


        switch(typeOfList){
            case "Artists" :
                textViewArtist.setText(string);
                break;

            case "Tunes" :
                textViewTune.setText(string);
                break;
        };
    }

    public void setButtonsClickListener(){

        final Button buttonTune = (Button) findViewById(R.id.tuneBtn);
        final Button buttonArtist = (Button) findViewById(R.id.artistBtn);

        buttonArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonTune.setEnabled(true);
                randomizeGenerators(listOfArtists, "Artists");
            }
        });

        buttonTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomizeGenerators(listOfTunes, "Tunes");
            }
        });
    }
}
