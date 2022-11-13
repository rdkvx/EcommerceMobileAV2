package com.example.javae_commerce.Entities;

/**
 *
 * @author Rodrigo Soares
 */
public interface pessoa {
    public String validaFuncionario(String nome, String email);
    public boolean autenticaFuncionario(String nome, String email);
}
