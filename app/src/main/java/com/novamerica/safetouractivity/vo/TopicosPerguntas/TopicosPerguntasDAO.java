package com.novamerica.safetouractivity.vo.TopicosPerguntas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.novamerica.safetouractivity.api.Conexao;

import java.util.ArrayList;
import java.util.List;

public class TopicosPerguntasDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public TopicosPerguntasDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public List<TopicosPerguntas> buscarTopicosPerguntas(){
        List<TopicosPerguntas> topicosPerguntas = new ArrayList<>();
        Cursor cursor = banco.query("TOPICOS_PERGUNTAS", new String[]{"id", "descricao"}, null, null,null,null,null);
        while (cursor.moveToNext()){
            TopicosPerguntas a = new TopicosPerguntas();
            a.setId(cursor.getInt(0));
            a.setDescricao(cursor.getString(1));
            topicosPerguntas.add(a);
        }
        return  topicosPerguntas;
    }


}
