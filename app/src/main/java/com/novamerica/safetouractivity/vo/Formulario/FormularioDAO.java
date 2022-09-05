package com.novamerica.safetouractivity.vo.Formulario;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.novamerica.safetouractivity.api.Conexao;

import java.util.ArrayList;
import java.util.List;

public class FormularioDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public FormularioDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public List<Formulario> buscarFormulariosByUsuario(String usuario){
        List<Formulario> formularios = new ArrayList<>();
        Cursor cursor = banco.query("formulario", new String[]{"id", "descricao"}, null, null,null,null,null);
        while (cursor.moveToNext()){
            Formulario a = new Formulario();
            a.setId(cursor.getInt(0));
            a.setDescricao(cursor.getString(1));
            formularios.add(a);
        }
        return  formularios;
    }
}
