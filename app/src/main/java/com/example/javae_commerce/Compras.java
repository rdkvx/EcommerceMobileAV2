package com.example.javae_commerce;

import static com.example.javae_commerce.MainActivity.produtos;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javae_commerce.Entities.produto;
import com.example.javae_commerce.Services.compraServices;
import com.example.javae_commerce.utils.constants;
import com.example.javae_commerce.utils.misc;

public class Compras extends AppCompatActivity {

    private Button btnBuscar;
    private Button btnComprar;
    private Button btnCancelar;
    private EditText formNomeProduto;
    private EditText formQtdProduto;
    private TextView pdtInfoCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnComprar = (Button) findViewById(R.id.btnComprar);

        btnBuscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                formNomeProduto = findViewById(R.id.formNomeProduto);
                String nmProduto = formNomeProduto.getText().toString();

                formQtdProduto = findViewById(R.id.formQtdProduto);
                String qtdProdutoStr = formQtdProduto.getText().toString();
                if(qtdProdutoStr.equals("")){
                    qtdProdutoStr = "0";
                }
                int qtdProduto = Integer.parseInt(qtdProdutoStr);

                btnBuscarActivity(nmProduto, qtdProduto);

            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                btnCancelarActivity();
            }
        });

        btnComprar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                formNomeProduto = findViewById(R.id.formNomeProduto);
                String nmProduto = formNomeProduto.getText().toString();

                formQtdProduto = findViewById(R.id.formQtdProduto);
                int qtdProduto = Integer.parseInt(formQtdProduto.getText().toString());

                btnComprarActivity(nmProduto, qtdProduto);
            }
        });
    }

    private void btnBuscarActivity(String nmProduto, int qtdProduto){
        produto p = new produto();

        int indice = p.indiceProduto(nmProduto);
        pdtInfoCompra = findViewById(R.id.pdtInfoCompra);

        String response = p.verificaProduto(indice, qtdProduto);

        if (!response.equals(constants.verificado)) {
            misc.msgAlert(btnBuscar.getContext(), response, constants.compraMenu);
        }else{
            if(produtos.get(indice).getQtdProduto() < qtdProduto){
                pdtInfoCompra.setText(response);
            }else{
                pdtInfoCompra.setText(p.getDados(produtos.get(indice)));
            }
        }
    }

    private void btnCancelarActivity(){
        startActivity(new Intent( Compras.this, PainelC.class));
    }

    private void btnComprarActivity(String nmProduto, int qtdProduto){
        produto p = new produto();

        int indice = p.indiceProduto(nmProduto);
        pdtInfoCompra = findViewById(R.id.pdtInfoCompra);

        String response = p.verificaProduto(indice, qtdProduto);

        if (!response.equals(constants.verificado)) {
            misc.msgAlert(btnBuscar.getContext(), response, constants.compraMenu);
        }else{
            if(produtos.get(indice).getQtdProduto() < qtdProduto){
                misc.msgAlert(btnBuscar.getContext(), response, constants.compraMenu);
            }else{
                compraServices c = new compraServices();
                boolean responseCompra = c.comprar(indice, qtdProduto);

                if(responseCompra){
                    misc.msgAlert(btnBuscar.getContext(), constants.compraEfetuada, constants.compraMenu);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent( Compras.this, PainelC.class));
                        }
                    }, constants.timeout);

                }else{
                    misc.msgAlert(btnBuscar.getContext(), constants.erroAoComprar, constants.compraMenu);
                }
            }
        }
    }

}