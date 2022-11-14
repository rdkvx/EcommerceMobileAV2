package com.example.javae_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javae_commerce.Entities.venda;
import com.example.javae_commerce.utils.constants;
import com.example.javae_commerce.utils.misc;

import java.util.Arrays;

public class Envios extends AppCompatActivity {

    private Button btnRealizaEnvio;
    private TextView envioProdutos;
    venda v = new venda();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envios);

        envioProdutos = findViewById(R.id.envioProdutos);

        String[] pd = v.verificaEnvioPendente();

        if(pd.length == 0 || pd == null){
            envioProdutos.setText(constants.semProdutosPendentes);
        }else{
            envioProdutos.setText(Arrays.toString(pd).replaceAll("\\[|\\]", ""));
        }

        btnRealizaEnvio = (Button) findViewById(R.id.btnRealizaEnvio);

        btnRealizaEnvio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                btnRealizaEnvioActivity();
            }
        });
    }

    private void btnRealizaEnvioActivity() {
        boolean response = v.trataEnvio();
        if(!response){
            misc.msgAlert(btnRealizaEnvio.getContext(), constants.semProdutosPendentes, constants.menuEnvioVendedor);
        }else{
            misc.msgAlert(btnRealizaEnvio.getContext(), constants.envioRealizado, constants.menuEnvioVendedor);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent( Envios.this, PainelV.class));
                }
            }, constants.timeout);
        }
    }
}