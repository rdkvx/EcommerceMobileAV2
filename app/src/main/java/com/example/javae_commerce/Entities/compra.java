package com.example.javae_commerce.Entities;

import java.util.ArrayList;


public class compra {
    public produto pdt;
    public boolean envio;

    //construtor padrão
    public compra(){

    }

    //Método para verificar se o produto já foi enviado ou não. Utilizado no menu do COMPRADOR, sobrescrevendo o método da classe mae
    public ArrayList<String> verificaEnvio(ArrayList<venda>compras){
        ArrayList<String> enviados = new ArrayList<String>();

        for(int i = 0; i < compras.size(); i++){
            if(compras.get(i).getEnvio() == false){
                enviados.add(""+compras.get(i).pdt.getNome()+": ENVIO PENDENTE");
            }else{
                enviados.add(""+compras.get(i).pdt.getNome()+": ENVIO REALIZADO");
            }
        }
        return enviados;
    }



}
