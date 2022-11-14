package com.example.javae_commerce;

import static com.example.javae_commerce.MainActivity.vendas;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javae_commerce.Services.vendaServices;
import com.example.javae_commerce.utils.constants;

import java.util.Arrays;

public class VendEfet extends AppCompatActivity {

    private TextView infoPainelVendas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vend_efet);

        infoPainelVendas = findViewById(R.id.infoPainelVendas);

        if(vendas.size() < 1){
            infoPainelVendas.setText(constants.vendaZerada);
        }else{
            String lista[];
            vendaServices vs = new vendaServices();

            lista = vs.listaVendas();

            infoPainelVendas.setText(Arrays.toString(lista).replaceAll("\\[|\\]", ""));
        }

    }
}