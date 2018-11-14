package com.simulandochamada.tecinfo.simulandochamada;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class Activity_telefone extends AppCompatActivity {

    private String memoria = "";
    TextView txtdisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefone);

        txtdisplay = (TextView) findViewById(R.id.txt_display);
        Button btnApagar = findViewById(R.id.btn_apagar);
        Button btn0 = findViewById(R.id.btn_0);
        Button btn1 = findViewById(R.id.btn_1);
        Button btn2 = findViewById(R.id.btn_2);
        Button btn3 = findViewById(R.id.btn_3);
        Button btn4 = findViewById(R.id.btn_4);
        Button btn5 = findViewById(R.id.btn_5);
        Button btn6 = findViewById(R.id.btn_6);
        Button btn7 = findViewById(R.id.btn_7);
        Button btn8 = findViewById(R.id.btn_8);
        Button btn9 = findViewById(R.id.btn_9);
        Button btnasterisco = findViewById(R.id.btn_asterisco);
        Button btnjogodavelha = findViewById(R.id.btn_jogodavelha);
        Button btnligar = findViewById(R.id.btn_ligar);

        btn0.setOnClickListener(myListener);
        btn1.setOnClickListener(myListener);
        btn2.setOnClickListener(myListener);
        btn3.setOnClickListener(myListener);
        btn4.setOnClickListener(myListener);
        btn5.setOnClickListener(myListener);
        btn6.setOnClickListener(myListener);
        btn7.setOnClickListener(myListener);
        btn8.setOnClickListener(myListener);
        btn9.setOnClickListener(myListener);
        btnasterisco.setOnClickListener(myListener);
        btnjogodavelha.setOnClickListener(myListener);
        btnApagar.setOnClickListener(myListener);
        btnligar.setOnClickListener(myListener);


    }

    private View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case (R.id.btn_0):
                    setDisplayText("0");
                    break;
                case (R.id.btn_1):
                    setDisplayText("1");
                    break;
                case (R.id.btn_2):
                    setDisplayText("2");
                    break;
                case (R.id.btn_3):
                    setDisplayText("3");
                    break;
                case (R.id.btn_4):
                    setDisplayText("4");
                    break;
                case (R.id.btn_5):
                    setDisplayText("5");
                    break;
                case (R.id.btn_6):
                    setDisplayText("6");
                    break;
                case (R.id.btn_7):
                    setDisplayText("7");
                    break;
                case (R.id.btn_8):
                    setDisplayText("8");
                    break;
                case (R.id.btn_9):
                    setDisplayText("9");
                    break;
                case (R.id.btn_asterisco):
                    setDisplayText("*");
                    break;
                case (R.id.btn_jogodavelha):
                    setDisplayText("#");
                    break;
                case (R.id.btn_apagar):
                    if(memoria.length() > 0) {
                        memoria = memoria.substring(0, memoria.length() - 1);
                        txtdisplay.setText(memoria);
                    }
                    break;
                case (R.id.btn_ligar):
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + memoria));

                    if (ActivityCompat.checkSelfPermission(Activity_telefone.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(Activity_telefone.this, new String[]{Manifest.permission.CALL_PHONE}, 0);
                    }
                    startActivity(intent);
                    break;
            }
        }
    };

    private void setDisplayText(String valor) {
        memoria = memoria + valor;
        txtdisplay.setText(memoria);
    }
}
