package com.novamerica.safetouractivity.ui.Integracao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


import com.novamerica.safetouractivity.Candidatos;
import com.novamerica.cadastroalunoactivity.R;
import com.novamerica.safetouractivity.api.ApiService;
import com.novamerica.safetouractivity.api.CEP;
import com.novamerica.safetouractivity.api.CEPService;
import com.novamerica.safetouractivity.api.DataService;
import com.novamerica.safetouractivity.api.Foto;
import com.novamerica.safetouractivity.api.Postagem;
import com.novamerica.safetouractivity.api.Usuario.UsuarioService;
import com.novamerica.safetouractivity.vo.Usuarios.Usuario;
import com.novamerica.safetouractivity.vo.Usuarios.UsuarioDAO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class IntegrarActivity extends AppCompatActivity {

    private CheckBox ckUsuarios;

    private UsuarioDAO dao;
    private List<Usuario> usuarios;

    private TextView txtEixoX;
    private TextView txtEixoY;
    private TextView txtResultIntegracao;

    private LocationManager locationManager;
    private LocationListener locationListener;

    private Button button;

    private Retrofit retrofit;
    private List<Foto> listaFoto = new ArrayList<>();
    private List<Postagem> listaPostagem = new ArrayList<>();

    private List<Usuario> listaUsuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integrar);
        ckUsuarios = findViewById(R.id.checkUsuarios);

        dao = new UsuarioDAO(this);
        usuarios = dao.obterTodosUsuarios();

        button = findViewById(R.id.btnRequest);
        txtEixoX = findViewById(R.id.txtEixoX);
        txtEixoY = findViewById(R.id.txtEixoY);
        txtResultIntegracao = findViewById(R.id.txtResultIntegracao);



        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                txtEixoX.setText("Latitude: " + location.getLatitude());
                txtEixoY.setText("Longitude: " + location.getLongitude());
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.INTERNET
                }, 10);
                return;
            }
        } else {
            configureButton();
        }
        locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 10:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    configureButton();
                return;
        }
    }

    private void configureButton() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);
            }
        });

    }

    private void getConvenioValues(){
        //embaixo funcionando buscar get
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiService.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiService service = retrofit.create(ApiService.class);
            Call<List<Candidatos>> requestUsuario = service.listUsuario();
            requestUsuario.enqueue(new Callback<List<Candidatos>>() {
                @Override
                public void onResponse(Call<List<Candidatos>> call, Response<List<Candidatos>> response) {
                    if (!response.isSuccessful()){
                        Log.i("TAG","Erro: "+response.code());
                    }else{
                        //Requisição retornou com sucesso
                        List<Candidatos> user = response.body();
//                        Log.i("Tag",user.getCodigo());
                    }
                }

                @Override
                public void onFailure(Call<List<Candidatos>> call, Throwable t) {
                    Log.e("suemar","Error");
                }
            });
    }

    private void recuperarListaFotoRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DataService dataService = retrofit.create(DataService.class);
        Call<List<Foto>> call = dataService.recuperarFotos();

        call.enqueue(new Callback<List<Foto>>() {
            @Override
            public void onResponse(Call<List<Foto>> call, Response<List<Foto>> response) {
                if (response.isSuccessful()){
                    listaFoto = response.body();
                    for (int i=0; i < listaFoto.size(); i++){
                        Foto foto = listaFoto.get(i);
                        Log.d("resultado: ", "resultado: "+foto.getId()+" / "+foto.getTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Foto>> call, Throwable t) {

            }
        });
    }

    private void recuperarListaPostagensRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DataService dataService = retrofit.create(DataService.class);
        Call<List<Postagem>> call = dataService.recuperarPostagens();

        call.enqueue(new Callback<List<Postagem>>() {
            @Override
            public void onResponse(Call<List<Postagem>> call, Response<List<Postagem>> response) {
                if (response.isSuccessful()){
                    listaPostagem = response.body();
                    for (int i=0; i < listaPostagem.size(); i++){
                        Postagem postagem = listaPostagem.get(i);
                        Log.d("resultado: ", "resultado: "+postagem.getId()+" / "+postagem.getTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Postagem>> call, Throwable t) {

            }
        });
    }

    private void recuperarCEPRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://viacep.com.br/ws/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CEPService cepService = retrofit.create(CEPService.class);
        Call<CEP> call = cepService.recuperarCEP("19820000");

        call.enqueue(new Callback<CEP>() {
            @Override
            public void onResponse(Call<CEP> call, Response<CEP> response) {
                if (response.isSuccessful()){
                    CEP cep = response.body();
                    txtResultIntegracao.setText(cep.getLogradouro() + " / " + cep.getBairro());
                }
            }

            @Override
            public void onFailure(Call<CEP> call, Throwable t) {

            }
        });
    }

    private void recuperarIntegracaoUsuarios(){
        String username="na.integracao";
        String password="#integra@Nva22!";
        String base = username+":"+password;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(StandardCharsets.UTF_8),Base64.NO_WRAP);

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                        Credentials.basic(username, password));

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(UsuarioService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsuarioService usuarioService = retrofit.create(UsuarioService.class);
        Call<List<Usuario>> call = usuarioService.recuperarUsuarios(authHeader);

        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if (response.isSuccessful()){
                    listaUsuarios = response.body();
                    for (int i=0; i < listaUsuarios.size(); i++){
                        Usuario usuario = listaUsuarios.get(i);
                        Log.d("resultado: ", "resultado: "+usuario.getMatricula()+" / "+usuario.getNome());
                    }
                }else{
                    Log.i("","Erro na consulta");
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {

            }
        });
    }

    public void integrar(View view){
        System.out.println(ckUsuarios);
        if (ckUsuarios.isChecked() == true){
            System.out.println("Integrando ... ");
//            recuperarCEPRetrofit();
//            recuperarListaFotoRetrofit();
//              salvarPostagem();
//                atualizarPostagem();
//            atualizarPostagemPatch();
//            removerPostagem();

            recuperarIntegracaoUsuarios();

        }else{
            System.out.println("Nao selecionado");
        }
        System.out.println(view);
    }

    private void removerPostagem(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DataService dataService = retrofit.create(DataService.class);
        Call<Void> call = dataService.removerPostagem(2);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()){
                    txtResultIntegracao.setText("Status: "+ response.code());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    private void atualizarPostagemPatch(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //configurar um objeto postagem
        Postagem postagem = new Postagem("1234",null,"Corpo da Postagem");

        DataService dataService = retrofit.create(DataService.class);
        Call<Postagem> call = dataService.atualizarPostagemPatch(2,postagem);
        call.enqueue(new Callback<Postagem>() {
            @Override
            public void onResponse(Call<Postagem> call, Response<Postagem> response) {
                if (response.isSuccessful()){
                    Postagem postagemResposta = response.body();

                    txtResultIntegracao.setText("Status: "+response.code() +
                            " id: "+postagemResposta.getId() +
                            " titulo: "+postagemResposta.getTitle()+
                            " body: "+postagemResposta.getBody());
                }
            }

            @Override
            public void onFailure(Call<Postagem> call, Throwable t) {

            }
        });
    }

    private void atualizarPostagem(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //configurar um objeto postagem
        Postagem postagem = new Postagem("1234",null,"Corpo da Postagem");

        DataService dataService = retrofit.create(DataService.class);
        Call<Postagem> call = dataService.atualizarPostagem(2,postagem);
        call.enqueue(new Callback<Postagem>() {
            @Override
            public void onResponse(Call<Postagem> call, Response<Postagem> response) {
                if (response.isSuccessful()){
                    Postagem postagemResposta = response.body();

                    txtResultIntegracao.setText("Status: "+response.code() +
                            " id: "+postagemResposta.getId() +
                            " titulo: "+postagemResposta.getTitle()+
                            " body: "+postagemResposta.getBody());
                }
            }

            @Override
            public void onFailure(Call<Postagem> call, Throwable t) {

            }
        });
    }

    private void salvarPostagem(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //configurar um objeto postagem
        Postagem postagem = new Postagem("1234","Título Postagem!","Corpo da Postagem");
        DataService dataService = retrofit.create(DataService.class);
        Call<Postagem> call = dataService.salvarPostagem(postagem);

        call.enqueue(new Callback<Postagem>() {
            @Override
            public void onResponse(Call<Postagem> call, Response<Postagem> response) {
                if (response.isSuccessful()){
                    Postagem postagemResposta = response.body();
                    txtResultIntegracao.setText("Código: "+response.code() +
                                              " id: "+postagemResposta.getId() +
                                                " titulo: "+postagemResposta.getTitle());
                }
            }

            @Override
            public void onFailure(Call<Postagem> call, Throwable t) {

            }
        });
    }
}