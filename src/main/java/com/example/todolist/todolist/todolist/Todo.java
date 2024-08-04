package com.example.todolist.todolist.todolist;

import com.example.todolist.todolist.todolist.prioridade.Prioridade;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "todos")
public class Todo {

    @NotBlank
    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @NotBlank
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "realizado")
    private boolean realizado = false;

    @Column(name = "prioridade")
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    public Todo() {
    }

    public Todo(String nome, String descricao, boolean realizado, Prioridade prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.realizado = realizado;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
}
