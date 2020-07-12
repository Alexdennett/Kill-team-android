package com.example.alexd.killteamprototype01;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    MediaPlayer backgroundMusic;

    public void launch(View view){
        mediaPlayer = MediaPlayer.create(this, R.raw.whoosh);
        mediaPlayer.start();
        backgroundMusic.stop();
        Intent myIntent = new Intent(getBaseContext(), InfoInput.class);
        startActivity(myIntent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backgroundMusic = MediaPlayer.create(this, R.raw.guardian);
        backgroundMusic.start();
        backgroundMusic.setLooping(true);

    }
}
