package com.novamerica.safetouractivity.vo.Perguntas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.novamerica.safetouractivity.api.Conexao;

import java.util.ArrayList;
import java.util.List;

public class PerguntasDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public PerguntasDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public List<Perguntas> buscarPerguntasById(){
        List<Perguntas> perguntas = new ArrayList<>();
        Cursor cursor = banco.query("PERGUNTAS", new String[]{"id", "formulario_id","topicos_perguntas_id","descricao_pergunta", "status", "pergunta_dinamica"}, null, null,null,null,null);
        while (cursor.moveToNext()){
            Perguntas a = new Perguntas();
            a.setId(cursor.getInt(0));
            a.setFormulario_id(cursor.getInt(1));
            a.setTopicos_perguntas_id(cursor.getInt(2));
            a.setDescricao_pergunta(cursor.getString(3));
            a.setStatus(cursor.getString(4));
            a.setPergunta_dinamica(cursor.getString(5));
            perguntas.add(a);
        }
        return perguntas;
    }

    public List<Perguntas> buscarPerguntasByTopicos(){
        List<Perguntas> perguntas = new ArrayList<>();
        Cursor cursor = banco.query("PERGUNTAS", new String[]{"id", "formulario_id","topicos_perguntas_id","descricao_pergunta", "status", "pergunta_dinamica"}, null, null,null,null,null);
        while (cursor.moveToNext()){
            Perguntas a = new Perguntas();
            a.setId(cursor.getInt(0));
            a.setFormulario_id(cursor.getInt(1));
            a.setTopicos_perguntas_id(cursor.getInt(2));
            a.setDescricao_pergunta(cursor.getString(3));
            a.setStatus(cursor.getString(4));
            a.setPergunta_dinamica(cursor.getString(5));
            perguntas.add(a);
        }
        return perguntas;
    }
}
