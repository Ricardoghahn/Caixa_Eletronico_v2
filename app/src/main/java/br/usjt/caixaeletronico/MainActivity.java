package br.usjt.caixaeletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String agencia = "br.usjt.caixaeletronico.AGENCIA";
    public final static String conta = "br.usjt.caixaeletronico.CONTA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logar(View view){
        EditText editTextAge = (EditText) findViewById(R.id.agencia);
        EditText editTextCon = (EditText) findViewById(R.id.conta);
        String age = editTextAge.getText().toString();
        String con = editTextCon.getText().toString();

        if ((age.equals(null) || age.equals("")) || (con.equals(null) || con.equals(""))) {

        } else {
            Intent intent = new Intent(this, PosLogin.class);
            intent.putExtra(agencia, age);
            intent.putExtra(conta, con);
            startActivity(intent);
        }
    }
}
