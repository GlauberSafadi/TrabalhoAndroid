package com.example.glauber.atv_01;

public class Estudante {

    //Atributos
    private String nome;
    private String telefone;
    private String rua;
    private String site;
    private int nota;

    //Construtor
    public Estudante(String nome, String telefone, String rua, String site, int nota){
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setRua(rua);
        this.setSite(site);
        this.setNota(nota);
    }

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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

}
