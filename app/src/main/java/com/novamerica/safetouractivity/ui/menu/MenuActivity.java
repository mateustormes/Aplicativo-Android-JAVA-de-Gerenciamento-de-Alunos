package com.novamerica.safetouractivity.ui.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import android.view.View;

import com.novamerica.cadastroalunoactivity.R;
import com.novamerica.safetouractivity.ui.Questionarios.QuestionariosActivity;
import com.novamerica.safetouractivity.ui.Usuario.ListarUsuarioActivity;

public class MenuActivity extends AppCompatActivity {

    private String sessionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        sessionId = getIntent().getStringExtra("valorcpf");
    }

    public boolean onCreateOptionsMenu(Menu menu){
        Bundle extras = getIntent().getExtras();
        MenuInflater i = getMenuInflater();

        i.inflate(R.menu.menu_logado, menu);
        menu.getItem(0).setTitle(sessionId);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.idTitleLogadoPrincipal:
//                System.out.println("principal");
//                item.setTitle(sessionId);
//                return true;
//            case R.id.idTitleLogado:
//                System.out.println("logado");
//                item.setTitle(sessionId);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }


    public void abrirUsuarios(View view){
        Intent intent = new Intent(this, ListarUsuarioActivity.class);
        intent.putExtra("valorcpf", sessionId.toString());
        startActivity(intent);
    }

    public void abrirQuestionarios(View view){
        Intent intent = new Intent(this, QuestionariosActivity.class);
        intent.putExtra("valorcpf", sessionId.toString());
        startActivity(intent);
    }
}