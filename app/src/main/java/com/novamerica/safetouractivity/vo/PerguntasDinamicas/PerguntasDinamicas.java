package com.novamerica.safetouractivity.vo.PerguntasDinamicas;

import java.io.Serializable;

public class PerguntasDinamicas implements Serializable {
    Integer id;
    Integer pergunta_id;
    String nome_pergunta;
    String resposta_pergunta;
    String integrado;
    String latitude;
    String longitude;

    @Override
    public String toString() {
        return "PerguntasDinamicas{" +
                "id=" + id +
                ", nome_pergunta='" + nome_pergunta + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPergunta_id() {
        return pergunta_id;
    }

    public void setPergunta_id(Integer pergunta_id) {
        this.pergunta_id = pergunta_id;
    }

    public String getNome_pergunta() {
        return nome_pergunta;
    }

    public void setNome_pergunta(String nome_pergunta) {
        this.nome_pergunta = nome_pergunta;
    }

    public String getResposta_pergunta() {
        return resposta_pergunta;
    }

    public void setResposta_pergunta(String resposta_pergunta) {
        this.resposta_pergunta = resposta_pergunta;
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
}
