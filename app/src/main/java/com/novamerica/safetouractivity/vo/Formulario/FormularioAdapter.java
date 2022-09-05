package com.novamerica.safetouractivity.vo.Formulario;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.novamerica.cadastroalunoactivity.R;

import java.util.List;

public class FormularioAdapter extends BaseAdapter {
    private List<Formulario> formularios;
    private Activity activity;

    public FormularioAdapter(Activity activity, List<Formulario> formularios){
        this.activity = activity;
        this.formularios = formularios;
    }

    @Override
    public int getCount(){
        return formularios.size();
    }

    @Override
    public Object getItem(int i){
        return formularios.get(i);
    }

    @Override
    public long getItemId(int i){
        return formularios.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        View v = activity.getLayoutInflater().inflate(R.layout.item, viewGroup, false);
        TextView nome = v.findViewById(R.id.txtNome);
        Formulario a = formularios.get(i);
        nome.setText(a.getDescricao());
        return v;
    }

}
