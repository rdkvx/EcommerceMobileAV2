package com.example.javae_commerce.Services;

import static com.example.javae_commerce.MainActivity.produtos;
import static com.example.javae_commerce.MainActivity.vendas;

import java.util.ArrayList;


/**
 *
 * @author digof
 */
public class vendaServices {
    utilidades utils = new utilidades();

    //Function para enviar o produto, utilizado no menu de VENDAS, sobrescrevendo o da classe mae.
    /*public String trataEnvio(ArrayList<com.example.javae_commerce.Entities.venda> produtos, int opte) throws IOException{
        for(int i = 0; i<produtos.size(); i++){
            if(produtos.get(i).getEnvio() == false){
                try {
                    switch(opte){
                        case 1:
                            produtos.get(i).setEnvio(true);
                            return "ENVIO REALIZADO COM SUCESSO";
                        case 2:
                            return "ENVIO NAO REALIZADO";

                        default:
                            return "INFORME UMA OPCAO VáLIDA!";
                    }
                } catch (Exception e) {
                    return "OPCAO INVALIDA";
                }
            }
            else{
                return " ENVIADO ANTERIORMENTE";
            }
        }
        return "PRODUTO NAO ENCONTRADO";
    }*/

    //Function para verificar quais os produtos já foram vendidos e o total do valor arrecadado.
    public String relatorioVendas(){
        float total = 0;
        for(int i = 0; i<produtos.size(); i++){
            total = total + (produtos.get(i).getPreco());
        }
        return "TOTAL DE VENDAS: R$"+total;
    }

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
