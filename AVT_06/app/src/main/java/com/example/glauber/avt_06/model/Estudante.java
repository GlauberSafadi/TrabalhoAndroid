package com.example.glauber.avt_06.model;

import java.io.Serializable;

public class Estudante implements Serializable{

    //Atributos
    private String nome;
    private String telefone;
    private int idade;

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
