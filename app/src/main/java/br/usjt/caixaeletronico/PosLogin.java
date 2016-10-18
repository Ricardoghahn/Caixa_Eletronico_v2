package br.usjt.caixaeletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PosLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos_login);

        Intent intent = getIntent();
        String agencia = intent.getStringExtra(MainActivity.agencia);
        String conta = intent.getStringExtra(MainActivity.conta);
        TextView textViewAge = (TextView) findViewById(R.id.tvAge);
        textViewAge.setText("Agência: " + agencia);
        TextView textViewCon = (TextView) findViewById(R.id.tvCon);
        textViewCon.setText("Conta: " + conta);
        Button cExtrato = (Button) findViewById(R.id.bExtrato);
    }

    public void consultarExtrato(View view) {
        Intent intent = new Intent(this, ListaExtrato.class);
        startActivity(intent);
    }
}
