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
    public static double saldoTotal;
    String age;
    String con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* if (dbHelper.selectCliente(1234)) {
            String msg = "Agência 1234 já inserida";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        } else { */
        //}

        /* if (dbHelper.selectCliente(9876)) {
            String msg = "Agência 9876 já inserida";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        } else { */
        //dbHelper.insertCliente(new Cliente(0, 9876, 232323, 850.00));
        // }
    }

    public void logar(View view) {
        EditText editTextAge = (EditText) findViewById(R.id.agencia);
        EditText editTextCon = (EditText) findViewById(R.id.conta);
        EditText editTextSen = (EditText) findViewById(R.id.senha);
        age = editTextAge.getText().toString();
        con = editTextCon.getText().toString();
        String senha = editTextSen.getText().toString();

        if ((age.equals("1234") && con.equals("121212") && senha.equals("1234")) || (age.equals("9876") && con.equals("232323") && senha.equals("9876"))) {
            Intent intent = new Intent(this, PosLogin.class);
            intent.putExtra(agencia, age);
            intent.putExtra(conta, con);
            startActivity(intent);
        } else {
            String msg = "Dados incorretos";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }
}
