package com.novamerica.safetouractivity.vo.TipoPlanoAcao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.novamerica.safetouractivity.api.Conexao;

import java.util.ArrayList;
import java.util.List;

public class TipoPlanoDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public TipoPlanoDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public List<TipoPlanoAcao> buscarTipoPlanoAcaoById(){
        List<TipoPlanoAcao> tipoPlanoAcao = new ArrayList<>();
        Cursor cursor = banco.query("TIPO_PLANO_ACAO", new String[]{"id", "descricao"}, null, null,null,null,null);
        while (cursor.moveToNext()){
            TipoPlanoAcao a = new TipoPlanoAcao();
            a.setId(cursor.getInt(0));
            a.setDescricao(cursor.getString(1));
            tipoPlanoAcao.add(a);
        }
        return  tipoPlanoAcao;
    }
}
