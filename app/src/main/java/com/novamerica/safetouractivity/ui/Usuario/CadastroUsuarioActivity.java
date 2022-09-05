package com.novamerica.safetouractivity.ui.Usuario;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.novamerica.cadastroalunoactivity.R;
import com.novamerica.safetouractivity.vo.Usuarios.Usuario;
import com.novamerica.safetouractivity.vo.Usuarios.UsuarioDAO;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private EditText nome;
    private EditText cpf;
    private EditText telefone;
    private UsuarioDAO dao;
    private Usuario usuario = null;

    ImageView imageView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);

        button = findViewById(R.id.btnTirarFoto);
        imageView = findViewById(R.id.imgViewFoto);
        if (ContextCompat.checkSelfPermission(CadastroUsuarioActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(CadastroUsuarioActivity.this, new String[]{
                    Manifest.permission.CAMERA
            }, 100);
        }


        nome = findViewById(R.id.inputNome);
        cpf = findViewById(R.id.inputCpf);
        telefone = findViewById(R.id.inputTelefone);
        dao = new UsuarioDAO(this);

        Intent it = getIntent();
        if (it.hasExtra("usuario")){
            usuario = (Usuario) it.getSerializableExtra("usuario");
            nome.setText(usuario.getNome());
            cpf.setText(usuario.getCpf());
            telefone.setText(usuario.getTelefone());
        }
    }

    public void tirarFoto(View view){
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
    }

    public void salvar(View view){
        if (usuario == null){
            usuario = new Usuario();
            usuario.setNome(nome.getText().toString());
            usuario.setCpf(cpf.getText().toString());
            usuario.setTelefone(telefone.getText().toString());
            long id = dao.inserir(usuario);
            Toast.makeText(this, "Aluno inserido com id: "+ id,Toast.LENGTH_LONG).show();
        }else{
            usuario.setNome(nome.getText().toString());
            usuario.setCpf(cpf.getText().toString());
            usuario.setTelefone(telefone.getText().toString());
            dao.atualizar(usuario);
            Toast.makeText(this, "Aluno foi atualizado",Toast.LENGTH_LONG).show();
        }

        Intent it = new Intent(this, ListarUsuarioActivity.class);
        startActivity(it);

    }
}