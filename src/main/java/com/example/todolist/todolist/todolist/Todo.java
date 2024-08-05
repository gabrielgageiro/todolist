package com.example.todolist.todolist.todolist;

import com.example.todolist.todolist.todolist.prioridade.Prioridade;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity(name = "todos")
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

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
    public Todo(Long id,String nome, String descricao, boolean realizado, Prioridade prioridade) {
        this(nome, descricao, realizado, prioridade);
        this.id = id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
