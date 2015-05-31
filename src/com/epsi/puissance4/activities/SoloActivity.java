package com.epsi.puissance4.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.epsi.puissance4.R;
import com.epsi.puissance4.views.GameView;

public class SoloActivity extends Activity implements View.OnClickListener{

    private Button btnLeave;
    private GameView gameView;
    private SoloActivity currentIntent = this;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single);
        gameView = (GameView) findViewById(R.id.gameView);
        btnLeave = (Button)findViewById(R.id.btnLeave);
        btnLeave.setOnClickListener(this);
        context= SoloActivity.this;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLeave:
                AlertDialog.Builder builderLeave = new AlertDialog.Builder(context);
                builderLeave.setMessage("Are you sure to want to leave ?");
                builderLeave.setCancelable(true);
                builderLeave.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogLeave, int id) {
                                Intent mainActivity = new Intent(currentIntent, MainActivity.class);
                                startActivity(mainActivity);
                                finish();
                            }
                        });
                builderLeave.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builderLeave.create();
                alert.show();
                ringtone();

                break;
        }

    }

    private void popupWIn(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
        builder.setMessage("Congratulations! You win, play again ?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        startActivity(getIntent());
                    }
                });
        builder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent mainActivity = new Intent(currentIntent,MainActivity.class);
                        startActivity(mainActivity);
                        finish();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
        ringtone();
    }
    public void ringtone(){
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

