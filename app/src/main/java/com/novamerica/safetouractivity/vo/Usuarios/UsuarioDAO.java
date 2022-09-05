package com.novamerica.safetouractivity.vo.Usuarios;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.novamerica.safetouractivity.api.Conexao;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public UsuarioDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("cpf", usuario.getCpf());
        values.put("telefone", usuario.getTelefone());
        return banco.insert("usuario", null, values);
    }

    public List<Usuario> obterTodosUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        Cursor cursor = banco.query("usuario", new String[]{"id", "nome", "cpf", "telefone"}, null, null,null,null,null);
        while (cursor.moveToNext()){
            Usuario a = new Usuario();
            a.setId(cursor.getInt(0));
            a.setNome(cursor.getString(1));
            a.setCpf(cursor.getString(2));
            a.setTelefone(cursor.getString(3));
            usuarios.add(a);
        }
        return  usuarios;
    }

    public void excluir(Usuario a){
        banco.delete("usuario","id = ?", new String[]{a.getId().toString()});
    }

    public void atualizar(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("cpf", usuario.getCpf());
        values.put("telefone", usuario.getTelefone());
        banco.update("usuario", values, "id = ?", new String[]{usuario.getId().toString()});

    }
}
