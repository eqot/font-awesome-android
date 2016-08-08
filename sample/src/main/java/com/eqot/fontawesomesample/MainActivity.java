package com.eqot.fontawesomesample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.eqot.fontawesome.FontAwesome;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FontAwesome.apply(this, findViewById(R.id.text));
        FontAwesome.apply(this, findViewById(R.id.button));
    }
}
