package com.example.javae_commerce;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javae_commerce.Entities.venda;

import java.util.ArrayList;

public class Envios extends AppCompatActivity {

    private Button btnRealizaEnvio;
    private TextView envioProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envios);

        envioProdutos = findViewById(R.id.envioProdutos);

        venda v = new venda();

        ArrayList<venda> vl = v.trataEnvio();

        if(vl.size() == 0){
            envioProdutos.setText("SEM PRODUTOS PENDENTES DE ENVIO");
        }else{
            for(int i = 0; i < vl.size(); i++){
                envioProdutos.setText(vl.get(i).pdt.getNome());
            }
        }

        btnRealizaEnvio = (Button) findViewById(R.id.btnRealizaEnvio);

        btnRealizaEnvio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });


    }
}