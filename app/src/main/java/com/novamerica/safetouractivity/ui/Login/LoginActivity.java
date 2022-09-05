package com.novamerica.safetouractivity.ui.Login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.novamerica.cadastroalunoactivity.R;
import com.novamerica.safetouractivity.ui.menu.MenuActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText inputCpf;
    private EditText inputSenha;
    private TextView txtMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputCpf = findViewById(R.id.inputLoginCpf);
        inputSenha = findViewById(R.id.inputLoginSenha);
        txtMensagem = findViewById(R.id.txtMensagem);
    }

    public void entrar(View view){
        if (inputCpf.getText().length() != 0 && inputSenha.getText().length() != 0){
            Intent it = new Intent(this, MenuActivity.class);
            it.putExtra("valorcpf", inputCpf.getText().toString());
            startActivity(it);
        }else{
            txtMensagem.setText(R.string.invalid_username);
            Toast.makeText(this, R.string.invalid_username,Toast.LENGTH_LONG).show();
        }
    }

    public void recuperarSenha(View view){
        AlertDialog.Builder enviaEmail = new AlertDialog.Builder(this);
        enviaEmail.setTitle("Enviar lista de contatos");
        enviaEmail.setMessage("Digite o e-mail do destinatário");
        enviaEmail.setCancelable(false);

        EditText editTextDigitarEmail = new EditText(this);

        LinearLayout.LayoutParams linearLayout = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        linearLayout.setMarginStart(16);
        editTextDigitarEmail.setLayoutParams(linearLayout);

        enviaEmail.setView(editTextDigitarEmail);
        enviaEmail.setPositiveButton("Enviar", null);
        enviaEmail.setNegativeButton("Cancelar", null);
        enviaEmail.create().show();
    }
}