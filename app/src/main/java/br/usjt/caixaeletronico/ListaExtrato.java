package br.usjt.caixaeletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaExtrato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_extrato);

        //Intent intent = getIntent();
        ListView listView = (ListView) findViewById(R.id.lvExtrato);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,geraExtrato());
        listView.setAdapter(arrayAdapter);
    }

    public ArrayList<String>geraExtrato(){
        ArrayList<String> extrato = new ArrayList<>();
        extrato.add("22/10/2016 " + "SAQUE: " + "R$ 15,00");
        extrato.add("23/10/2016 " + "SAQUE: " + "R$ 25,00");
        extrato.add("24/10/2016 " + "SAQUE: " + "R$ 40,00");
        extrato.add("25/10/2016 " + "SAQUE: " + "R$ 10,00");
        return extrato;
    }
}
