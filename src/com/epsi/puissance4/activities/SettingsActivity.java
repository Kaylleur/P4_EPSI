package com.epsi.puissance4.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.epsi.puissance4.R;

public class SettingsActivity extends Activity  implements View.OnClickListener {

    private Button btnCancel;
    private Button btnSave;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnCancel.setOnClickListener(this);
        btnSave.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                Intent intentSettings = new Intent(this, MainActivity.class);
                startActivity(intentSettings);
                break;
            case R.id.btnCancel:
                Intent intentMulti = new Intent(this, MainActivity.class);
                startActivity(intentMulti);
                break;

        }
    }
}

