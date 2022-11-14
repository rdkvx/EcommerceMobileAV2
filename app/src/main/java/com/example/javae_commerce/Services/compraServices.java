package com.example.javae_commerce.Services;

import static com.example.javae_commerce.MainActivity.produtos;
import static com.example.javae_commerce.MainActivity.vendas;

import com.example.javae_commerce.Entities.produto;
import com.example.javae_commerce.Entities.venda;

import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

/**
 *
 * @author digof
 */
public class compraServices {
    // metodo retorna uma compra para ser adicionada na lista de vendas
    public boolean comprar(int indice, int qtdProduto){
        venda vendaNova = new venda();
        produto p = new produto();
       try{
           produtos.get(indice).setQtdProduto(produtos.get(indice).getQtdProduto() - qtdProduto);

           p.setIdProduto(produtos.get(indice).getIdProduto());
           p.setNome(produtos.get(indice).getNome());
           p.setPreco(produtos.get(indice).getPreco()*qtdProduto);
           p.setQtdProduto(qtdProduto);
           vendaNova.pdt = p;
           vendaNova.setEnvio(false);

           vendas.add(vendaNova);
           return true;

       }catch (MissingFormatArgumentException e){
            return false;
       }
    }

    /*// retorna um array com os status de envio das compras
    public ArrayList<String> verificaEnvio(ArrayList<com.example.javae_commerce.Entities.venda> vendas){
        compra cpra = new compra();
        return cpra.verificaEnvio(vendas);
    }*/

    // retorna um array com as informacoes de todos os produtos
    public String[] listaProdutos(){
        ArrayList<String> listaProduto = new ArrayList<String>();

        int i;

        for(i=0; i< produtos.size(); i++){
            listaProduto.add(""+produtos.get(i).getDados(produtos.get(i)));
        }

        String listaPronta[] = new String[i];

        for(i=0; i<listaProduto.size(); i++){
            listaPronta[i] = listaProduto.get(i);
        }
        return listaPronta;
    }

}