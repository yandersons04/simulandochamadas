package com.simulandochamada.tecinfo.simulandochamada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_telefone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefone);

        TextView numeros = (TextView) findViewById(R.id.edt_numeros);
    };
}
