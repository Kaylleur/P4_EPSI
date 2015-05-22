package com.epsi.puissance4.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.epsi.puissance4.R;

public class MultiMode extends Activity implements View.OnClickListener{

    private Button btnSurrend;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single);
        btnSurrend = (Button) findViewById(R.id.btnSurrend);
        btnSurrend.setOnClickListener(this);

    }
    public void onClick(View v) {
        if (v == btnSurrend) {
            Intent intention = new Intent(this,Main.class);
            startActivity(intention);
        }
    }
}


