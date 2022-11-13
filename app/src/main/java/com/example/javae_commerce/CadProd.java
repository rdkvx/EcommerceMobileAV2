package com.example.javae_commerce;

import static com.example.javae_commerce.MainActivity.produtos;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javae_commerce.Entities.produto;
import com.example.javae_commerce.utils.constants;
import com.example.javae_commerce.utils.misc;

public class CadProd extends AppCompatActivity {

    private Button btnCadProduto;
    private EditText formCadastroCodProduto;
    private EditText formCadastroNmProduto;
    private EditText formCadastroValorProduto;
    private EditText formCadastroQtdProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_prod);

        btnCadProduto = (Button) findViewById(R.id.btnCadastroProduto);

        btnCadProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formCadastroCodProduto = findViewById(R.id.formCadastroCodProduto);
                String codProduto = formCadastroCodProduto.getText().toString();

                formCadastroNmProduto = findViewById(R.id.formCadastroNmProduto);
                String nmProduto = formCadastroNmProduto.getText().toString();

                formCadastroValorProduto = findViewById(R.id.formCadastroValorProduto);
                String vlrProdutoStr =  formCadastroValorProduto.getText().toString();
                if(vlrProdutoStr.equals("")){
                    vlrProdutoStr = "0";
                }
                float vlrProduto = Float.parseFloat(vlrProdutoStr);

                formCadastroQtdProduto = findViewById(R.id.formCadastroQtdProduto);
                String qtdProdutoStr =  formCadastroQtdProduto.getText().toString();
                if(qtdProdutoStr.equals("")){
                    qtdProdutoStr = "0";
                }
                int qtdProduto = Integer.parseInt(qtdProdutoStr);

                btnCadastraProduto(codProduto, nmProduto, vlrProduto, qtdProduto);
            }
        });
    }

    private void btnCadastraProduto(String idProduto, String nmProduto, float preco, int qtdProduto){
        produto p = new produto();

       String response = p.validaProduto(idProduto, nmProduto, preco, qtdProduto);

       if(response != constants.produtoValidado){
           misc.msgAlert(btnCadProduto.getContext(), response, constants.cadastroProduto);
       } else {
           p.setIdProduto(idProduto);
           p.setNome(nmProduto);
           p.setPreco(preco);
           p.setQtdProduto(qtdProduto);

           produtos.add(p);
           misc.msgAlert(btnCadProduto.getContext(), constants.produtoCadastrado, constants.cadastroProduto);

           Handler handler = new Handler();
           handler.postDelayed(new Runnable() {
               @Override
               public void run() {
                   startActivity(new Intent( CadProd.this, Produtos.class));
               }
           }, constants.timeout);
       }

    }
}