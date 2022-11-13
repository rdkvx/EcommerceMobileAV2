package com.example.javae_commerce.Entities;

import static com.example.javae_commerce.MainActivity.funcionarios;

import com.example.javae_commerce.utils.constants;

import java.util.ArrayList;
import java.util.InputMismatchException;


/**
 *
 * @author Rodrigo Soares
 */

//classe funcionario implementando interface pessoa
public class funcionario implements pessoa {

    private String email;
    private String nome;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Construtor padrão
    public funcionario(){

    }

    //método para auxiliar na validação do cadastro do funcionário.
    public int getindiceFuncionario(ArrayList<funcionario> funcionarios, String email){
        for(int i = 0; i < funcionarios.size(); i++){
            if(funcionarios.get(i).getEmail().equals(email)){
                return i;
            }
        }
        return -1;
    }

    //método vindo da interface pessoa, utilizada para cadastrar novos funcionarios
    @Override
    public String validaFuncionario(String nome, String email){
        try {
            if(!email.contains("@") || email.length() < 1){
                return constants.emailInvalido;
            }

            if(nome.length() <1 ){
                return constants.nomeInvalido;
            }

        } catch (InputMismatchException e) {
           return constants.dadosInvalidos;
        }
      return constants.cadastroValidado;
    }

    @Override
    public boolean autenticaFuncionario(String nome, String email){
        boolean encontrou = false;
        nome = nome.toLowerCase();
        email = email.toLowerCase();

        for(int i = 0; i < funcionarios.size(); i++){
            String arrNome = funcionarios.get(i).getNome().toLowerCase();
            String arrEmail = funcionarios.get(i).getEmail().toLowerCase();

            if(nome.equals(arrNome) && email.equals(arrEmail)){
                encontrou = true;
                break;
            }
        }

        return encontrou;
    }
}
