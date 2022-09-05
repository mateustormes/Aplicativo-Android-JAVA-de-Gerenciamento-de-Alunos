package com.novamerica.safetouractivity.vo.Respostas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.novamerica.safetouractivity.api.Conexao;

import java.util.ArrayList;
import java.util.List;

public class RespostasDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public RespostasDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public List<Respostas> buscarRespostasByPerguntaId(){
        List<Respostas> respostas = new ArrayList<>();
        Cursor cursor = banco.query("RESPOSTAS", new String[]{"usuario_id", "formulario_id", "tipo_respostas_id", "pergunta_id", "integrado", "latitude", "longitude"}, null, null,null,null,null);
        while (cursor.moveToNext()){
            Respostas a = new Respostas();
            a.setUsuario_id(cursor.getInt(0));
            a.setFormulario_id(cursor.getInt(1));
            a.setTipo_respostas_id(cursor.getInt(2));
            a.setPergunta_id(cursor.getInt(3));
            a.setIntegrado(cursor.getString(4));
            a.setLatitude(cursor.getString(5));
            a.setLongitude(cursor.getString(6));
            respostas.add(a);
        }
        return  respostas;
    }

    public long inserirRespostas(Respostas respostas){
        ContentValues values = new ContentValues();
        values.put("usuario_id", respostas.getUsuario_id());
        values.put("formulario_id", respostas.getFormulario_id());
        values.put("tipo_respostas_id", respostas.getTipo_respostas_id());
        values.put("perguntas_id", respostas.getPergunta_id());
        values.put("latitude", respostas.getLatitude());
        values.put("longitude", respostas.getLongitude());
        return banco.insert("RESPOSTAS", null, values);
    }

    public long atualizarRespostas(Respostas respostas){
        ContentValues values = new ContentValues();
        values.put("usuario_id", respostas.getUsuario_id());
        values.put("formulario_id", respostas.getFormulario_id());
        values.put("tipo_respostas_id", respostas.getTipo_respostas_id());
        values.put("perguntas_id", respostas.getPergunta_id());
        values.put("latitude", respostas.getLatitude());
        values.put("longitude", respostas.getLongitude());
        return banco.update("RESPOSTAS", values, "usuario_id = ?, formulario_id = ?, tipo_respostas_id = ?, perguntas_id = ?", new String[]{
                                                                                                                    respostas.getUsuario_id().toString(),
                                                                                                                    respostas.getFormulario_id().toString(),
                                                                                                                    respostas.getTipo_respostas_id().toString(),
                                                                                                                    respostas.getPergunta_id().toString()
        });
    }
}
