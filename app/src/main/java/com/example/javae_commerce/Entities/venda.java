package com.example.javae_commerce.Entities;

import static com.example.javae_commerce.MainActivity.vendas;

import java.util.ArrayList;

public class venda {
    public produto pdt;
    private boolean envio;

    public void setEnvio(boolean envio){
        this.envio = envio;
    }

    public boolean getEnvio(){
        return envio;
    }

    com.example.javae_commerce.Services.utilidades utils = new com.example.javae_commerce.Services.utilidades();

    //Construtor padrão
    public venda(){

    }

    //Método para enviar o produto, utilizado no menu de VENDAS, sobrescrevendo o da classe mae.
    public ArrayList<venda> trataEnvio(){
        ArrayList<venda> enviosPendentes = new ArrayList<venda>();
        for(int i = 0; i < vendas.size(); i++){
            if(vendas.get(i).getEnvio() == false){
                enviosPendentes.add(vendas.get(i));
            }
        }
        return enviosPendentes;
    }



    //Método para verificar quais os produtos já foram vendidos e o total do valor arrecadado.
   /* public void relatorioVendas(ArrayList<venda> produtos){
        float total = 0;
        for(int i = 0; i<produtos.size(); i++){
            System.out.println(""+produtos.get(i).getDadosVendas());
            total = total + (produtos.get(i).getPreco());
        }
        System.out.println("\nTOTAL DE VENDAS: R$"+total);
    }*/





    //Metodo para verificar se o produto está cadastrado na base, buscando pelo indice.
   /* public int getIndice(ArrayList<venda> produtos, String id){
        for(int i = 0; i < produtos.size(); i++){
            if(produtos.get(i).getIdProduto().equals(id)){
                return i;
            }
        }
        return -1;
    }*/

    //Metodo para retornar os dados totais de venda
    /*public String getDadosVendas(){
        return ("\nID: "+getIdProduto()+"\nNOME: "+getNome()+"\nQUANTIDADE VENDIDA: "+getQtdProduto()+"\nTOTAL: R$"+getPreco());
    }*/
}
