package com.epsi.puissance4.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.epsi.puissance4.R;

public class Main extends Activity implements View.OnClickListener{

    private Button btnSingle;
    private Button btnMulti;
    private Button btnSettings;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnSettings = (Button) findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(this);

        btnSingle = (Button) findViewById(R.id.btnSingle);
        btnSingle.setOnClickListener(this);

        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnMulti.setOnClickListener(this);

    }
    public void onClick(View v) {
        if (v == btnSettings) {
             Intent intention = new Intent(this,Settings.class);
            startActivity(intention);
        }else if(v == btnSingle) {
            Intent intention = new Intent(this, ViewGame.class);
            startActivity(intention);
        }else if (v == btnMulti) {
            Intent intention = new Intent(this, MultiMode.class);
            startActivity(intention);
        }
    }
}


