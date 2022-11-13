package com.example.javae_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Produtos extends AppCompatActivity {


    private Button btnMenuNovoProduto, btnMenuRemoveProduto, btnMenuPdtsEnvioPendente, btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);


        btnMenuNovoProduto = (Button) findViewById(R.id.btnMenuNovoProduto);
        btnMenuRemoveProduto = (Button) findViewById(R.id.btnMenuRemoveProduto);
        btnMenuPdtsEnvioPendente = (Button) findViewById(R.id.btnMenuPdtsEnvioPendente);
        btnHome = (Button) findViewById(R.id.btnHome);


        btnMenuNovoProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnMenuNovoProdutoActivity();
            }
        });

        btnMenuRemoveProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnMenuRemoveProdutoActivity();
            }
        });

        btnMenuPdtsEnvioPendente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnMenuPdtsEnvioPendenteActivity();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                btnHomeActivity();
            }
        });

    }

    private void btnMenuNovoProdutoActivity() {

        startActivity(new Intent(Produtos.this, CadProd.class));
    }

    private void btnMenuRemoveProdutoActivity() {

        startActivity(new Intent(Produtos.this, RemovProd.class));
    }

    private void btnMenuPdtsEnvioPendenteActivity() {

        startActivity(new Intent(Produtos.this, Envios.class));
    }

    private void btnHomeActivity() {

        startActivity(new Intent(Produtos.this, MainActivity.class));
    }
}