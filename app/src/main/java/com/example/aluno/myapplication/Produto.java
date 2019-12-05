package com.example.aluno.myapplication;

import com.orm.SugarRecord;

public class Produto extends SugarRecord {

    private String nome;
    private int quantidade;
    private String data;
    private Double preco;

    public Produto() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;

    }

    @Override
    public String toString() {
        return nome + " - R$" + preco ;
    }
}
