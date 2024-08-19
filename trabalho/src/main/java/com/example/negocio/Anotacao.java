package com.example.negocio;

import java.time.LocalDateTime;

public class Anotacao {
    private int id;
    private String titulo;
    private LocalDateTime data_hora;
    private String descricao;
    private String cor;

    public Anotacao(int id, String titulo, LocalDateTime data_hora, String descricao, String cor){
        this.id = id;
        this.titulo = titulo;
        this.data_hora = data_hora;
        this.descricao = descricao;
        this.cor = cor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

}
