package com.example.javae_commerce;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javae_commerce.Services.compraServices;

import java.util.Arrays;

public class ListProd extends AppCompatActivity {

    private TextView txtInfoProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_prod);

        compraServices c = new compraServices();

        String[] listaProdutos;

        listaProdutos = c.listaProdutos();

        txtInfoProduto = findViewById(R.id.txtInfoProduto);

        txtInfoProduto.setText(Arrays.toString(listaProdutos).replaceAll("\\[|\\]", ""));
    }
}