package com.example.todolist.todolist.todolist.prioridade;

public enum Prioridade {
    BAIXA("Baixa"),
    MEDIA("Media"),
    ALTA("Alta");;

    public final String desgricao;

    Prioridade(String desgricao) {
        this.desgricao = desgricao;
    }

    public String getDesgricao() {
        return desgricao;
    }
}
