package com.example.javae_commerce.Services;

import static com.example.javae_commerce.MainActivity.vendas;

import java.util.ArrayList;


/**
 *
 * @author digof
 */
public class vendaServices {
    public String[] listaVendas(){
        ArrayList<String> listaVenda = new ArrayList<String>();

        int i;

        for(i=0; i< vendas.size(); i++){
            listaVenda.add(""+vendas.get(i).getDadosVenda(vendas.get(i)));
        }

        String listaPronta[] = new String[i];

        for(i=0; i<listaVenda.size(); i++){
            listaPronta[i] = listaVenda.get(i);
        }
        return listaPronta;
    }
}
