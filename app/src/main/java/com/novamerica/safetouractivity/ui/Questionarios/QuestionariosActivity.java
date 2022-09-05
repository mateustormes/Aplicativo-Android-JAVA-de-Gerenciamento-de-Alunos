package com.novamerica.safetouractivity.ui.Questionarios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import com.novamerica.cadastroalunoactivity.R;
import com.novamerica.safetouractivity.vo.Formulario.Formulario;
import com.novamerica.safetouractivity.vo.Formulario.FormularioAdapter;
import com.novamerica.safetouractivity.vo.Formulario.FormularioDAO;


import java.util.ArrayList;
import java.util.List;

public class QuestionariosActivity extends AppCompatActivity {

    private ListView listView;
    private FormularioDAO dao;
    private List<Formulario> formulario;
    private List<Formulario> formularioFiltrados = new ArrayList<>();

    private String sessionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionarios);

        listView = findViewById(R.id.lista_questionarios);
        dao = new FormularioDAO(this);
        sessionId = getIntent().getStringExtra("valorcpf");

        formulario = dao.buscarFormulariosByUsuario("mateus");
        formularioFiltrados.addAll(formulario);
//
        FormularioAdapter adapter = new FormularioAdapter(this, formularioFiltrados);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_logado, menu);
        menu.getItem(0).setTitle(sessionId);
        return true;
    }
}