package com.novamerica.safetouractivity.vo.TipoRespostas;

import java.io.Serializable;

public class TipoRespostas implements Serializable {
    Integer id;
    String conceito;
    String situacao;
    Integer nota;
    String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConceito() {
        return conceito;
    }

    public void setConceito(String conceito) {
        this.conceito = conceito;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TipoRespostas{" +
                "conceito='" + conceito + '\'' +
                ", nota=" + nota +
                '}';
    }
}
