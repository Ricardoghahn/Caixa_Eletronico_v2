package br.usjt.caixaeletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ConsultarSaldo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_saldo);

        Intent intent = getIntent();
        double saldo = intent.getDoubleExtra(PosLogin.saldo, PosLogin.saldoTotal);
        TextView textViewAge = (TextView) findViewById(R.id.tvSaldo);
        textViewAge.setText("Saldo: R$" + saldo);
    }
}
