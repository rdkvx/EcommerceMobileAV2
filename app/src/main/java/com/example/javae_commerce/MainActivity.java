package com.example.javae_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javae_commerce.Entities.funcionario;
import com.example.javae_commerce.Entities.produto;
import com.example.javae_commerce.Entities.venda;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnComprador, btnVendedor;

    public static final ArrayList<produto> produtos = new ArrayList(); //LISTA QUE PERSISTIRÁ TODOS OS PRODUTOS CADASTRADOS.
    public static final ArrayList<venda> vendas = new ArrayList(); //LISTA QUE PERSISTIRÁ TODAS AS COMPRAS E VENDAS CADASTRADAS.
    public static final ArrayList<funcionario> funcionarios = new ArrayList(); //LISTA QUE PERSISTIRÁ TODOS OS FUNCIONARIOS.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnComprador = (Button) findViewById(R.id.btnComprador);
        btnVendedor = (Button) findViewById(R.id.btnVendedor);

        btnComprador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCompradorActivity();
            }
        });

        btnVendedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnVendedorActivity();
            }
        });
    }

    private void btnCompradorActivity() {

        startActivity(new Intent(MainActivity.this, PainelC.class));
    }

    private void btnVendedorActivity() {

        startActivity(new Intent(MainActivity.this, AutenVend.class));

    }
}