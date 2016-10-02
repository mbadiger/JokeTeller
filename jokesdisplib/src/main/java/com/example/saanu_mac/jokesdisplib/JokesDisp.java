package com.example.saanu_mac.jokesdisplib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokesDisp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_disp);


        TextView textView = (TextView) findViewById(R.id.txtjokes);

        Intent intent = getIntent();
        if (intent != null) {

            String joke = intent.getStringExtra("JOKES");
            textView.setText(joke);
        }
    }
}
