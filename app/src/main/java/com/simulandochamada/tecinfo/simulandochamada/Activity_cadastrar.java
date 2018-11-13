package com.simulandochamada.tecinfo.simulandochamada;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_cadastrar extends AppCompatActivity {

    SharedPreferences meusDados;
    public static final String mypreference = "call";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        meusDados = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        final EditText novoEmail = findViewById(R.id.edt_novoemail);
        final EditText novaSenha = findViewById(R.id.edt_novasenha);
        final EditText confirmaSenha = findViewById(R.id.edt_confirmarsenha);
        Button btncadstrar = (Button) findViewById(R.id.btn_cadastrar);

        btncadstrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                if (novaSenha.getText().toString().equals(confirmaSenha.getText().toString())){

                    SharedPreferences.Editor editor = meusDados.edit();
                    editor.putString("email", novoEmail.getText().toString());
                    editor.putString("senha", novaSenha.getText().toString());

                    editor.commit();

                    Toast.makeText(getApplicationContext(),
                            "Dadoa salvos com sucesso!", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(Activity_cadastrar.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }   else {
                    Toast.makeText(getApplicationContext(),
                            "As senhas não conferem", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
