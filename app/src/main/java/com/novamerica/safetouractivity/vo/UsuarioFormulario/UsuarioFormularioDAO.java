package com.novamerica.safetouractivity.vo.UsuarioFormulario;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.novamerica.safetouractivity.api.Conexao;

import java.util.ArrayList;
import java.util.List;

public class UsuarioFormularioDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public UsuarioFormularioDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public List<UsuarioFormulario> buscarFormulariosByUsuarioId(){
        List<UsuarioFormulario> usuarioFormularios = new ArrayList<>();
        Cursor cursor = banco.query("USUARIO_FORMULARIO", new String[]{"formulario_id","usuario_id", "entrevistado_id", "lider_id","dataLimite","respondido","pontuacao_geral",
                        "integrado","area_entrevistado","turno","horaInicio","horaFim","latitude","longitude"}, null, null,null,null,null);
        while (cursor.moveToNext()){
            UsuarioFormulario a = new UsuarioFormulario();
            a.setFormulario_id(cursor.getInt(0));
            a.setUsuario_id(cursor.getInt(1));
            a.setEntrevistado_id(cursor.getInt(2));
            a.setLider_id(cursor.getInt(3));
            a.setDataLimite(cursor.getString(4));
            a.setRespondido(cursor.getString(5));
            a.setPontuacaoGeral(cursor.getInt(6));
            a.setIntegrado(cursor.getString(7));
            a.setAreaEntrevistado(cursor.getString(8));
            a.setTurno(cursor.getString(9));
            a.setHoraInicio(cursor.getString(10));
            a.setHoraFim(cursor.getString(11));
            a.setLatitude(cursor.getString(12));
            a.setLongitude(cursor.getString(13));
            usuarioFormularios.add(a);
        }
        return  usuarioFormularios;
    }

    public List<UsuarioFormulario> buscarFormulariosRespondidos(){
        List<UsuarioFormulario> usuarioFormularios = new ArrayList<>();
        Cursor cursor = banco.query("USUARIO_FORMULARIO", new String[]{"formulario_id","usuario_id", "entrevistado_id", "lider_id","dataLimite","respondido","pontuacao_geral",
                "integrado","area_entrevistado","turno","horaInicio","horaFim","latitude","longitude"}, null, null,null,null,null);
        while (cursor.moveToNext()){
            UsuarioFormulario a = new UsuarioFormulario();
            a.setFormulario_id(cursor.getInt(0));
            a.setUsuario_id(cursor.getInt(1));
            a.setEntrevistado_id(cursor.getInt(2));
            a.setLider_id(cursor.getInt(3));
            a.setDataLimite(cursor.getString(4));
            a.setRespondido(cursor.getString(5));
            a.setPontuacaoGeral(cursor.getInt(6));
            a.setIntegrado(cursor.getString(7));
            a.setAreaEntrevistado(cursor.getString(8));
            a.setTurno(cursor.getString(9));
            a.setHoraInicio(cursor.getString(10));
            a.setHoraFim(cursor.getString(11));
            a.setLatitude(cursor.getString(12));
            a.setLongitude(cursor.getString(13));
            usuarioFormularios.add(a);
        }
        return  usuarioFormularios;
    }
}
