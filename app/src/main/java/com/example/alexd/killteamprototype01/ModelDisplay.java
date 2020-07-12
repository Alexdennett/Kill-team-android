package com.example.alexd.killteamprototype01;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ModelDisplay extends AppCompatActivity {
    int intModelWounds;
    int maxModelWounds;
    Boolean isShaken = false;
    Boolean hasFleshWound = false;
    MediaPlayer mediaPlayer;
    MediaPlayer backgroundMusic;
    Boolean userFleshWound = false;

    public void decreaseModelWounds(View view) {
        TextView modelWounds = (TextView) findViewById(R.id.woundCounter);
        ImageView img = (ImageView) findViewById(R.id.modelView);
        if (intModelWounds > 0) {
            mediaPlayer = MediaPlayer.create(this, R.raw.shoom);
            mediaPlayer.start();
            intModelWounds--;
            modelWounds.setText(String.valueOf(intModelWounds));
            view.invalidate();
        }
        if (intModelWounds == 0){
            woundsAtZero(view);
            mediaPlayer = MediaPlayer.create(this, R.raw.fallen);
            mediaPlayer.start();
            img.setImageResource(R.drawable.fallenspacemarine);
        }
    }

    public void increaseModelWounds(View view) {
        ImageView img = (ImageView) findViewById(R.id.modelView);
        TextView modelWounds = (TextView) findViewById(R.id.woundCounter);
        if (intModelWounds == maxModelWounds){
            Toast.makeText(this, "MAX WOUNDS FOR THIS MODEL", Toast.LENGTH_SHORT).show();
            return;
        }
        if (intModelWounds == 0){
            img.setImageResource(R.drawable.spacemarine);
            isShaken = false;
            view.invalidate();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.update);
        mediaPlayer.start();
        intModelWounds++;
        modelWounds.setText(String.valueOf(intModelWounds));
        view.invalidate();
    }

    public void setModelToShaken(View view){
        ImageView img = (ImageView) findViewById(R.id.modelView);
        if (isShaken == false && intModelWounds > 0){
            mediaPlayer = MediaPlayer.create(this, R.raw.shaken);
            mediaPlayer.start();
            img.setImageResource(R.drawable.shakenspacemarine);
            view.invalidate();
            isShaken = true;
            return;
        }

        if (isShaken == true && intModelWounds > 0 ){
            mediaPlayer = MediaPlayer.create(this, R.raw.update);
            mediaPlayer.start();
            img.setImageResource(R.drawable.spacemarine);
            view.invalidate();
            isShaken = false;
        }
    }

    public void fleshWound(View view){
        ImageView fleshWound = (ImageView) findViewById(R.id.fleshWoundMarker);
        if (hasFleshWound == false){
            mediaPlayer = MediaPlayer.create(this, R.raw.shoom);
            mediaPlayer.start();
            fleshWound.setImageResource(R.drawable.fleshwound);
            hasFleshWound = true;
            view.invalidate();
            return;
        }
        else{
            mediaPlayer = MediaPlayer.create(this, R.raw.update);
            mediaPlayer.start();
            fleshWound.setImageResource(R.drawable.greyfleshwound);
            hasFleshWound = false;
            view.invalidate();
            return;
        }
    }

    /// FLESH WOUND FEATURE NOT WORKING
    public void woundsAtZero(final View view){
 /*
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("MODEL WOUNDS = 0");
        alertDialogBuilder.setIcon(R.drawable.fleshwound);
        alertDialogBuilder.setTitle("FLESH WOUND?");

        alertDialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(ModelDisplay.this, "FLESH WOUND", Toast.LENGTH_LONG).show();
                userFleshWound = true;
                return;
            }
        });

        alertDialogBuilder.setNegativeButton("NO",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ModelDisplay.this,"KILLED",Toast.LENGTH_LONG).show();
                userFleshWound = false;
                justAFleshWound(view);
                return;
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
 */
    }

    public void justAFleshWound(View view){
       /* ImageView img = (ImageView) findViewById(R.id.modelView);
        TextView modelWounds = (TextView) findViewById(R.id.woundCounter);
        intModelWounds++;
        modelWounds.setText(String.valueOf(intModelWounds));
        view.invalidate();
        hasFleshWound = false;
        img.setImageResource(R.drawable.spacemarine);
        fleshWound(view);
*/
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_display);
        backgroundMusic = MediaPlayer.create(this, R.raw.mechvoldown);
        backgroundMusic.start();
        backgroundMusic.setLooping(true);

        String savedName = getIntent().getStringExtra("modelName");
        String savedWounds = getIntent().getStringExtra("modelWounds");
        TextView modelName = (TextView) findViewById(R.id.nameView);
        TextView modelWounds = (TextView) findViewById(R.id.woundCounter);
        intModelWounds = Integer.parseInt(savedWounds);
        maxModelWounds = Integer.parseInt(savedWounds);
        modelName.setText(savedName.toUpperCase());
        modelWounds.setText(savedWounds.toString());

        Log.i("INFO", "Wounds int:  " + intModelWounds);
    }
}
