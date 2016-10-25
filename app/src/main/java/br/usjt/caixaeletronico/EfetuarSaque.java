package br.usjt.caixaeletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;

public class EfetuarSaque extends AppCompatActivity {

    public final static String saldo = "br.usjt.caixaeletronico.SALDO";
    String sValor;
    double dSaldo, dValor;
    EditText valorMonetario;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_efetuar_saque);

        Intent intent = getIntent();
        dSaldo = intent.getDoubleExtra(PosLogin.saldo, PosLogin.saldoTotal);

        valorMonetario = (EditText) findViewById(R.id.etValor);

        valorMonetario.addTextChangedListener(new MascaraMonetaria(valorMonetario));
    }

    public void realizarSaque(View view) {
        //final EditText editTextValor = (EditText) findViewById(R.id.etValor);
        sValor = valorMonetario.getText().toString();
        sValor = sValor.replaceAll("[R$]", "").replaceAll("[,]", ".");
        dValor = Double.parseDouble(sValor);

        if (dValor > dSaldo) {
            String msg = "Saldo Insuficiente, seu saldo atual é de: R$ " + dSaldo;
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        } else {
            dSaldo -= dValor;
            String msg = "Saque efetuado com sucesso! " + "\nSeu novo saldo é de: R$" + dSaldo;
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            telaSaldo(view);
        }
    }

    private void telaSaldo(View view) {
        Intent intent = new Intent(this, ConsultarSaldo.class);
        intent.putExtra(saldo, dSaldo);
        startActivity(intent);
    }

    private class MascaraMonetaria implements TextWatcher {

        final EditText campo;
        private boolean isUpdating = false;
        // Pega a formatacao do sistema, se for brasil R$ se EUA US$
        private NumberFormat nf = NumberFormat.getCurrencyInstance();

        public MascaraMonetaria(EditText campo) {
            super();
            this.campo = campo;
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int after) {
            // Evita que o método seja executado varias vezes.
            // Se tirar ele entre em loop

            if (isUpdating) {
                isUpdating = false;
                return;
            }


            isUpdating = true;
            String str = s.toString();
            // VerifiCa se já existe a máscara no texto.
            boolean hasMask = ((str.indexOf("R$") > -1 || str.indexOf("$") > -1) && (str.indexOf(".") > -1 || str.indexOf(",") > -1));

            // Verificamos se existe máscara

            if (hasMask) {
                // Retiramos a máscara.
                str = str.replaceAll("[R$]", "").replaceAll("[,]", "").replaceAll("[.]", "");
            }


            try {
                // Transformamos o número que está escrito no EditText em
                // monetário.
                str = nf.format(Double.parseDouble(str) / 100);
                campo.setText(str);
                campo.setSelection(campo.getText().length());
            } catch (NumberFormatException e) {
                s = "";
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // Não utilizado
        }

        @Override
        public void afterTextChanged(Editable s) {
            // Não utilizado
        }
    }
}