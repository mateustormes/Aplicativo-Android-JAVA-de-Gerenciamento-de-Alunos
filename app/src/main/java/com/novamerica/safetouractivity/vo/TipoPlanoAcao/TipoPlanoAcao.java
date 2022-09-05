package com.novamerica.safetouractivity.vo.TipoPlanoAcao;

import java.io.Serializable;

public class TipoPlanoAcao implements Serializable {
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
    public String toString() {
        return "TipoPlanoAcao{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
