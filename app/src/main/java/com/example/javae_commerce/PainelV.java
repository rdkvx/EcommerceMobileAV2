package com.example.javae_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PainelV extends AppCompatActivity {

    private Button btnCadProd, btnChecarProduto, btnVendasEfetuadas, btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painelv);

        btnChecarProduto = (Button) findViewById(R.id.btnChecarProduto);
        btnCadProd = (Button) findViewById(R.id.btnCadProd);
        btnVendasEfetuadas = (Button) findViewById(R.id.btnVendasEfetuadas);
        btnInicio = (Button) findViewById(R.id.btnInicio);

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnInicioActivity();
            }
        });

        btnCadProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnCadProdActivity();
            }
        });


        btnChecarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnChecarProdutoActivity();
            }
        });

        btnVendasEfetuadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnVendasEfetuadasActivity();

            }
        });

    }

    private void btnInicioActivity() {

        startActivity(new Intent(PainelV.this, MainActivity.class));
    }

    private void btnVendasEfetuadasActivity() {

        startActivity(new Intent(PainelV.this, VendEfet.class));
    }

    private void btnChecarProdutoActivity() {

        startActivity(new Intent(PainelV.this, Envios.class));
    }

    private void btnCadProdActivity() {

        startActivity(new Intent(PainelV.this, Produtos.class));
    }
}