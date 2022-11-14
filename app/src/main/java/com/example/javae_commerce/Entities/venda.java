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

    //Construtor padrão
    public venda(){

    }

    //Método para enviar o produto, utilizado no menu de VENDAS, sobrescrevendo o da classe mae.
    public String[] verificaEnvioPendente(){
        ArrayList<String> enviosPendentes = new ArrayList<String>();

        int i;

        boolean found = false;

        for(i = 0; i < vendas.size(); i++){
            if(!vendas.get(i).getEnvio()){
                enviosPendentes.add(""+vendas.get(i).getDadosVenda(vendas.get(i)));
                found = true;
            }
        }

        if (found){
            String pendentes[] = new String[i];

            for(i=0; i < enviosPendentes.size(); i++){
                pendentes[i] = enviosPendentes.get(i);
            }
            return pendentes;
        }

        String pendentes[] = new String[0];
        return  pendentes;
    }

    public Boolean trataEnvio(){
        boolean found = false;

        if(vendas.size() > 0){
            for(int i = 0; i < vendas.size(); i++){
                if(!vendas.get(i).getEnvio()){
                    vendas.get(i).setEnvio(true);
                    found = true;
                }
            }
        }
        if(found){
            return true;
        }
        return false;
    }

    public String getDadosVenda(venda v){
        return ("\nID: "+v.pdt.getIdProduto()+"\nNome: "+v.pdt.getNome()+"\nPreco: R$"+v.pdt.getPreco()+ "\nQuantidade: "+v.pdt.getQtdProduto());
    }
}
