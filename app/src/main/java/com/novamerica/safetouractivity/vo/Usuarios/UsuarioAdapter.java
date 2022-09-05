package com.novamerica.safetouractivity.vo.Usuarios;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.novamerica.cadastroalunoactivity.R;

import java.util.List;

public class UsuarioAdapter extends BaseAdapter {
    private List<Usuario> usuarios;
    private Activity activity;

    public UsuarioAdapter(Activity activity, List<Usuario> usuarios){
        this.activity = activity;
        this.usuarios = usuarios;
    }

    @Override
    public int getCount(){
        return usuarios.size();
    }

    @Override
    public Object getItem(int i){
        return usuarios.get(i);
    }

    @Override
    public long getItemId(int i){
        return usuarios.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        View v = activity.getLayoutInflater().inflate(R.layout.item, viewGroup, false);
        TextView nome = v.findViewById(R.id.txtNome);
        TextView cpf = v.findViewById(R.id.txtCpf);
        TextView telefone = v.findViewById(R.id.txtTelefone);
        Usuario a = usuarios.get(i);
        nome.setText(a.getNome());
        cpf.setText(a.getCpf());
        telefone.setText(a.getTelefone());
        return v;
    }

}
