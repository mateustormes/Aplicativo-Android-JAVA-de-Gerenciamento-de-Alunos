package com.novamerica.safetouractivity.vo.TipoRespostas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.novamerica.safetouractivity.api.Conexao;

import java.util.ArrayList;
import java.util.List;

public class TipoRespostasDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public TipoRespostasDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public List<TipoRespostas> buscarTipoRespostasAll(){
        List<TipoRespostas> tipoRespostas = new ArrayList<>();
        Cursor cursor = banco.query("TIPO_RESPOSTAS", new String[]{"id", "conceito", "situacao", "nota", "status"}, null, null,null,null,null);
        while (cursor.moveToNext()){
            TipoRespostas a = new TipoRespostas();
            a.setId(cursor.getInt(0));
            a.setConceito(cursor.getString(1));
            a.setSituacao(cursor.getString(2));
            a.setNota(cursor.getInt(3));
            a.setStatus(cursor.getString(4));
            tipoRespostas.add(a);
        }
        return  tipoRespostas;
    }

    public List<TipoRespostas> buscarTipoRespostasById(){
        List<TipoRespostas> tipoRespostas = new ArrayList<>();
        Cursor cursor = banco.query("TIPO_RESPOSTAS", new String[]{"id", "conceito", "situacao", "nota", "status"}, null, null,null,null,null);
        while (cursor.moveToNext()){
            TipoRespostas a = new TipoRespostas();
            a.setId(cursor.getInt(0));
            a.setConceito(cursor.getString(1));
            a.setSituacao(cursor.getString(2));
            a.setNota(cursor.getInt(3));
            a.setStatus(cursor.getString(4));
            tipoRespostas.add(a);
        }
        return  tipoRespostas;
    }
}
