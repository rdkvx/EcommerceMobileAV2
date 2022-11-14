package com.example.javae_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PainelC extends AppCompatActivity {

    private Button btnListProd, btnEnvioCompr, btnCompra, btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painelc);

        btnCompra = (Button) findViewById(R.id.btnCompra);
        btnEnvioCompr = (Button) findViewById(R.id.btnEnvioCompr);
        btnListProd = (Button) findViewById(R.id.btnListProd);
        btnInicio = (Button) findViewById(R.id.btnInicio);

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnInicioActivity();
            }
        });


        btnListProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnListProdActivity();

            }
        });

        btnCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnCompraActivity();

            }
        });

        btnEnvioCompr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnEnvioComprActivity();

            }
        });
    }

    private void btnCompraActivity() {

        startActivity(new Intent(PainelC.this, Compras.class));

    }

    private void btnEnvioComprActivity() {

        startActivity(new Intent(PainelC.this, EnvioCompr.class));
    }

    private void btnListProdActivity() {

        startActivity( new Intent(PainelC.this, ListProd.class));
    }

    private void btnInicioActivity() {

        startActivity( new Intent(PainelC.this, MainActivity.class));
    }
}