package com.novamerica.safetouractivity.vo.UsuarioFormulario;

import java.io.Serializable;

public class UsuarioFormulario implements Serializable {
    Integer formulario_id;
    Integer usuario_id;
    Integer entrevistado_id;
    Integer lider_id;
    String dataLimite;
    String respondido;
    Integer pontuacaoGeral;
    String integrado;
    String areaEntrevistado;
    String turno;
    String horaInicio;
    String horaFim;
    String latitude;
    String longitude;

    public Integer getFormulario_id() {
        return formulario_id;
    }

    public void setFormulario_id(Integer formulario_id) {
        this.formulario_id = formulario_id;
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Integer getEntrevistado_id() {
        return entrevistado_id;
    }

    public void setEntrevistado_id(Integer entrevistado_id) {
        this.entrevistado_id = entrevistado_id;
    }

    public Integer getLider_id() {
        return lider_id;
    }

    public void setLider_id(Integer lider_id) {
        this.lider_id = lider_id;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getRespondido() {
        return respondido;
    }

    public void setRespondido(String respondido) {
        this.respondido = respondido;
    }

    public Integer getPontuacaoGeral() {
        return pontuacaoGeral;
    }

    public void setPontuacaoGeral(Integer pontuacaoGeral) {
        this.pontuacaoGeral = pontuacaoGeral;
    }

    public String getIntegrado() {
        return integrado;
    }

    public void setIntegrado(String integrado) {
        this.integrado = integrado;
    }

    public String getAreaEntrevistado() {
        return areaEntrevistado;
    }

    public void setAreaEntrevistado(String areaEntrevistado) {
        this.areaEntrevistado = areaEntrevistado;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
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
