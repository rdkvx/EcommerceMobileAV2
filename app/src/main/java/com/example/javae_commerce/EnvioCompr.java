package com.example.javae_commerce;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javae_commerce.Entities.venda;
import com.example.javae_commerce.Services.compraServices;
import com.example.javae_commerce.utils.constants;

import java.util.Arrays;

public class EnvioCompr extends AppCompatActivity {

    private TextView txtProdutoPendente;
    private TextView txtProdutoRealizado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio_compr);

        txtProdutoPendente = findViewById(R.id.txtProdutoPendente);
        txtProdutoRealizado = findViewById(R.id.txtProdutoRealizado);

        venda v = new venda();

        String[] pd = v.verificaEnvioPendente();

        if(pd.length == 0 || pd == null){
            txtProdutoPendente.setText(constants.semProdutosPendentes);
        }else{
            txtProdutoPendente.setText(Arrays.toString(pd).replaceAll("\\[|\\]", ""));
        }

        compraServices cs = new compraServices();

        String[] env =  cs.verificaEnvioRealizado();

        if(env.length == 0 || env == null){
            txtProdutoRealizado.setText(constants.semProdutosPendentes);
        }else{
            txtProdutoRealizado.setText(Arrays.toString(env).replaceAll("\\[|\\]", ""));
        }
    }
}