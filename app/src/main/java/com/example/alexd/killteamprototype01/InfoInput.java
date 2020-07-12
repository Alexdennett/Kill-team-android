package com.example.alexd.killteamprototype01;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class InfoInput extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    MediaPlayer backgroundMusic;
    public void enterButton(View view) {
        EditText modelName = (EditText) findViewById(R.id.nameTextView);
        EditText modelWounds = (EditText) findViewById(R.id.woundsTextView);
        if (modelName.getText().toString().length() > 0 && modelWounds.getText().toString().length() > 0){
            mediaPlayer = MediaPlayer.create(this, R.raw.whoosh);
            mediaPlayer.start();
            backgroundMusic.stop();
            Intent myIntent = new Intent(getBaseContext(), ModelDisplay.class);
            myIntent.putExtra("modelName", modelName.getText().toString());
            myIntent.putExtra("modelWounds", modelWounds.getText().toString());
            startActivity(myIntent);
        }

        else{
            Toast.makeText(this, "ERROR: PLEASE ENTER NAME AND WOUNDS", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_input);
        backgroundMusic = MediaPlayer.create(this, R.raw.guardian);
        backgroundMusic.start();
        backgroundMusic.setLooping(true);
    }
}
