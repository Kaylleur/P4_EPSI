package com.epsi.puissance4.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.epsi.puissance4.R;

public class MainActivity extends Activity implements View.OnClickListener{

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

        switch(v.getId()){
            case R.id.btnSettings:
                Intent intentSettings = new Intent(this,SettingsActivity.class);
                startActivity(intentSettings);
                break;
            case R.id.btnMulti:
                Intent intentMulti = new Intent(this,MultiActivity.class);
                startActivity(intentMulti);
                break;
            case R.id.btnSingle:
                Intent intentSingle = new Intent(this,SoloActivity.class);
                startActivity(intentSingle);
                break;
        }
    }
}