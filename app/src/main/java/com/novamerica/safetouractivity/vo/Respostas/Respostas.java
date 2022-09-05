package com.novamerica.safetouractivity.vo.Respostas;

import java.io.Serializable;

public class Respostas implements Serializable {
    Integer usuario_id;
    Integer formulario_id;
    Integer tipo_respostas_id;
    Integer pergunta_id;
    String integrado;
    String latitude;
    String longitude;

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

    public Integer getTipo_respostas_id() {
        return tipo_respostas_id;
    }

    public void setTipo_respostas_id(Integer tipo_respostas_id) {
        this.tipo_respostas_id = tipo_respostas_id;
    }

    public Integer getPergunta_id() {
        return pergunta_id;
    }

    public void setPergunta_id(Integer pergunta_id) {
        this.pergunta_id = pergunta_id;
    }

    public String getIntegrado() {
        return integrado;
    }

    public void setIntegrado(String integrado) {
        this.integrado = integrado;
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

    @Override
    public String toString() {
        return "Respostas{" +
                "integrado='" + integrado + '\'' +
                '}';
    }
}
