package com.example.javae_commerce.Entities;


import static com.example.javae_commerce.MainActivity.produtos;

import com.example.javae_commerce.utils.constants;

import java.io.Serializable;

public class produto implements Serializable{
    private String idProduto;
    private String nome;
    private float preco;
    private int qtdProduto;

    //Construtor padrão
    public void produto(){

    }

    public void setIdProduto(String IDProduto){
        this.idProduto = IDProduto;
    }

    public void setNome(String Nome){
        this.nome = Nome;
    }

    public void setPreco(float Preco){
        this.preco = Preco;
    }

    public void setQtdProduto(int QtdProduto){
        this.qtdProduto = QtdProduto;
    }


    public String getIdProduto(){
        return this.idProduto;
    }

    public String getNome(){
        return this.nome;
    }

    public float getPreco(){
        return this.preco;
    }

    public int getQtdProduto(){
        return this.qtdProduto;
    }


    public boolean removeProduto(String idProduto){
        for(int i = 0; i < produtos.size(); i++){
            if(idProduto.equals(produtos.get(i).getIdProduto())){
                produtos.remove(i);
                return true;
            }

        }
        return false;
    }

    //Método para cadastrar produtos
    public String validaProduto(String idProduto, String nmProduto, float preco, int qtdProduto){
        if (idProduto.equals("")){
            return constants.idInvalido;
        }

        if (nmProduto.equals("")){
            return constants.nomeInvalido;
        }

        for(int i = 0; i < produtos.size(); i++){
            if(idProduto.equals(produtos.get(i).idProduto)){
                return constants.ErroIdCadastrado;
            }
            if(nmProduto.equals(produtos.get(i).nome)){
                return constants.ErroNomeCadastrado;
            }
        }

        if (preco < 1){
            return constants.precoInvalido;
        }

        if (qtdProduto < 1){
            return constants.qtdInvalida;
        }

        return constants.produtoValidado;
    }

    public int indiceProduto(String nmProduto){
        for(int i=0; i<produtos.size(); i++){
            if(produtos.get(i).getNome().equals(nmProduto)){
                return i;
            }
        }
        return -1;
    }

    //Metodo para retornar os dados da compra
    public String getDados(produto p){
        return ("\nID: "+p.getIdProduto()+"\nNome: "+p.getNome()+"\nPreco: R$"+p.getPreco()+ "\nQuantidade: "+p.getQtdProduto());
    }

    public String verificaProduto(int indice, int qtdProduto){
       if (indice < 0) {
            return constants.produtoNaoEncontrado;
        }else{
            if(produtos.get(indice).getQtdProduto() < 1){
                return constants.produtoEsgotado;
            }else{
                if(produtos.get(indice).getQtdProduto() < qtdProduto || qtdProduto < 1){
                    return ("Apenas "+produtos.get(indice).getQtdProduto()+" disponiveis");
                }
            }
        }
        return (constants.verificado);
    }
}