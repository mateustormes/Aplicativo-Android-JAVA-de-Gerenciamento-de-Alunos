package com.novamerica.safetouractivity.vo.PlanoAcao;

import java.io.Serializable;

public class PlanoAcao implements Serializable {
    Integer usuario_id;
    Integer formulario_id;
    Integer pergunta_id;
    Integer resposta_id;
    Integer tipo_plano_id;
    String descricao;
    String integrado;
    Integer responsavel;
    String prazo;
    String latitude;
    String longitude;

    @Override
    public String toString() {
        return "PlanoAcao{" +
                "pergunta_id=" + pergunta_id +
                ", resposta_id=" + resposta_id +
                '}';
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Integer getFormulario_id() {
        return formulario_id;
    }

    public void setFormulario_id(Integer formulario_id) {
        this.formulario_id = formulario_id;
    }

    public Integer getPergunta_id() {
        return pergunta_id;
    }

    public void setPergunta_id(Integer pergunta_id) {
        this.pergunta_id = pergunta_id;
    }

    public Integer getResposta_id() {
        return resposta_id;
    }

    public void setResposta_id(Integer resposta_id) {
        this.resposta_id = resposta_id;
    }

    public Integer getTipo_plano_id() {
        return tipo_plano_id;
    }

    public void setTipo_plano_id(Integer tipo_plano_id) {
        this.tipo_plano_id = tipo_plano_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIntegrado() {
        return integrado;
    }

    public void setIntegrado(String integrado) {
        this.integrado = integrado;
    }

    public Integer getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Integer responsavel) {
        this.responsavel = responsavel;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
