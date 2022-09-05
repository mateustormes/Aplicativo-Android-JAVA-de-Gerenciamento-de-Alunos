package com.novamerica.safetouractivity.vo.Perguntas;

import java.io.Serializable;

public class Perguntas implements Serializable {
    Integer id;
    Integer formulario_id;
    Integer topicos_perguntas_id;
    String descricao_pergunta;
    String status;
    String pergunta_dinamica;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFormulario_id() {
        return formulario_id;
    }

    public void setFormulario_id(Integer formulario_id) {
        this.formulario_id = formulario_id;
    }

    public Integer getTopicos_perguntas_id() {
        return topicos_perguntas_id;
    }

    public void setTopicos_perguntas_id(Integer topicos_perguntas_id) {
        this.topicos_perguntas_id = topicos_perguntas_id;
    }

    public String getDescricao_pergunta() {
        return descricao_pergunta;
    }

    public void setDescricao_pergunta(String descricao_pergunta) {
        this.descricao_pergunta = descricao_pergunta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPergunta_dinamica() {
        return pergunta_dinamica;
    }

    public void setPergunta_dinamica(String pergunta_dinamica) {
        this.pergunta_dinamica = pergunta_dinamica;
    }

    @Override
    public String toString(){
        return getDescricao_pergunta();
    }
}
