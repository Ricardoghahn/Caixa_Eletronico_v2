package br.usjt.caixaeletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public final static String agencia = "br.usjt.caixaeletronico.AGENCIA";
    public final static String conta = "br.usjt.caixaeletronico.CONTA";
    String age;
    String con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logar(View view){
        EditText editTextAge = (EditText) findViewById(R.id.agencia);
        EditText editTextCon = (EditText) findViewById(R.id.conta);
        age = editTextAge.getText().toString();
        con = editTextCon.getText().toString();

        if ((age.equals("1234") && con.equals("121212")) || (age.equals("9876") && con.equals("232323"))) {
            Intent intent = new Intent(this, PosLogin.class);
            intent.putExtra(agencia, age);
            intent.putExtra(conta, con);
            startActivity(intent);
        } else {
            String msg = "Agência e/ou Conta incorretos";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }
}
