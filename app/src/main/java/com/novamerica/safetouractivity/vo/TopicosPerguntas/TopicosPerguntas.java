package com.novamerica.safetouractivity.vo.TopicosPerguntas;

import java.io.Serializable;

public class TopicosPerguntas implements Serializable {
    Integer id;
    String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        return getDescricao();
    }
}
