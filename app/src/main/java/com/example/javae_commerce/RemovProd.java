package com.example.javae_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javae_commerce.Entities.venda;
import com.example.javae_commerce.utils.constants;
import com.example.javae_commerce.utils.misc;

public class RemovProd extends AppCompatActivity {

    private Button btnRemoveProduto;
    private EditText idProdutoForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remov_prod);

        btnRemoveProduto = (Button) findViewById(R.id.btnRemoveProduto);

        btnRemoveProduto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                idProdutoForm = findViewById(R.id.formCodProdutoDel);
                String idProduto = idProdutoForm.getText().toString();

                btnRemoveProdutoActivity(idProduto);
            }
        });
    }

    private void btnRemoveProdutoActivity(String idProduto){
        venda v = new venda();

        boolean response = v.removeProduto(idProduto);

        if(!response){
            misc.msgAlert(btnRemoveProduto.getContext(), constants.erroAoRemoverProduto, constants.produtoMenu);
        }else{
            misc.msgAlert(btnRemoveProduto.getContext(), constants.produtoRemovido, constants.produtoMenu);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent( RemovProd.this, Produtos.class));
                }
            }, constants.timeout);
        }
    }
}