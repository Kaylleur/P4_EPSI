package com.epsi.puissance4.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.epsi.puissance4.R;
import com.epsi.puissance4.views.GameView;

public class SoloActivity extends Activity implements View.OnClickListener{

    private Button btnLeave;
    private GameView gameView;
    SoloActivity currentIntent = this;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single);
        gameView = (GameView) findViewById(R.id.gameView);
        btnLeave = (Button)findViewById(R.id.btnLeave);
        btnLeave.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {


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
    }
}


