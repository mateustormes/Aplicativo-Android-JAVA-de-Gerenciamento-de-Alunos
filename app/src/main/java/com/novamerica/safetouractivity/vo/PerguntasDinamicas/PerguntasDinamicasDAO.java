package com.novamerica.safetouractivity.vo.PerguntasDinamicas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.novamerica.safetouractivity.api.Conexao;

import java.util.ArrayList;
import java.util.List;

public class PerguntasDinamicasDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public PerguntasDinamicasDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public List<PerguntasDinamicas> buscarPerguntasDinamicasByPerguntaId(){
        List<PerguntasDinamicas> perguntasDinamicas = new ArrayList<>();
        Cursor cursor = banco.query("TIPO_PLANO_ACAO", new String[]{"id", "pergunta_id", "nome_pergunta", "resposta_pergunta", "integrado", "latitude", "longitude"}, null, null,null,null,null);
        while (cursor.moveToNext()){
            PerguntasDinamicas a = new PerguntasDinamicas();
            a.setId(cursor.getInt(0));
            a.setPergunta_id(cursor.getInt(1));
            a.setNome_pergunta(cursor.getString(2));
            a.setResposta_pergunta(cursor.getString(3));
            a.setIntegrado(cursor.getString(4));
            a.setLatitude(cursor.getString(5));
            a.setLongitude(cursor.getString(6));
            perguntasDinamicas.add(a);
        }
        return  perguntasDinamicas;
    }

    public void atualizarPerguntasDinamicas(PerguntasDinamicas perguntasDinamicas){
        ContentValues values = new ContentValues();
        values.put("resposta_pergunta", perguntasDinamicas.getResposta_pergunta());
        values.put("latitude", perguntasDinamicas.getLatitude());
        values.put("longitude", perguntasDinamicas.getLongitude());
        banco.update("PERGUNTAS_DINAMICAS", values, "id = ?", new String[]{perguntasDinamicas.getId().toString()});

    }
}
