package com.novamerica.safetouractivity.vo.PlanoAcao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.novamerica.safetouractivity.api.Conexao;

import java.util.ArrayList;
import java.util.List;

public class PlanoAcaoDao {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public PlanoAcaoDao(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public List<PlanoAcao> buscarPlanoAcaoByPerguntaId(){
        List<PlanoAcao> planoAcao = new ArrayList<>();
        Cursor cursor = banco.query("PLANO_ACAO", new String[]{"usuario_id", "formulario_id", "pergunta_id", "resposta_id", "tipo_plano_id", "descricao", "integrado",
                        "responsavel", "prazo", "latitude", "longitude"}, null, null,null,null,null);
        while (cursor.moveToNext()){
            PlanoAcao a = new PlanoAcao();
            a.setUsuario_id(cursor.getInt(0));
            a.setFormulario_id(cursor.getInt(1));
            a.setPergunta_id(cursor.getInt(2));
            a.setResposta_id(cursor.getInt(3));
            a.setTipo_plano_id(cursor.getInt(4));
            a.setDescricao(cursor.getString(5));
            a.setIntegrado(cursor.getString(6));
            a.setResponsavel(cursor.getInt(7));
            a.setPrazo(cursor.getString(8));
            a.setLatitude(cursor.getString(9));
            a.setLongitude(cursor.getString(10));
            planoAcao.add(a);
        }
        return  planoAcao;
    }

    public List<PlanoAcao> buscarPlanoAcaoByFormularioId(){
        List<PlanoAcao> planoAcao = new ArrayList<>();
        Cursor cursor = banco.query("PLANO_ACAO", new String[]{"usuario_id", "formulario_id", "pergunta_id", "resposta_id", "tipo_plano_id", "descricao", "integrado",
                "responsavel", "prazo", "latitude", "longitude"}, null, null,null,null,null);
        while (cursor.moveToNext()){
            PlanoAcao a = new PlanoAcao();
            a.setUsuario_id(cursor.getInt(0));
            a.setFormulario_id(cursor.getInt(1));
            a.setPergunta_id(cursor.getInt(2));
            a.setResposta_id(cursor.getInt(3));
            a.setTipo_plano_id(cursor.getInt(4));
            a.setDescricao(cursor.getString(5));
            a.setIntegrado(cursor.getString(6));
            a.setResponsavel(cursor.getInt(7));
            a.setPrazo(cursor.getString(8));
            a.setLatitude(cursor.getString(9));
            a.setLongitude(cursor.getString(10));
            planoAcao.add(a);
        }
        return  planoAcao;
    }
}
