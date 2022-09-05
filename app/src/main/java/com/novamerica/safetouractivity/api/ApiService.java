package com.novamerica.safetouractivity.api;

import com.novamerica.safetouractivity.Candidatos;
import com.novamerica.safetouractivity.vo.Usuarios.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    public static final String BASE_URL = "https://conveniodes.novamerica.com.br/api/v1/contato/";

    @GET("estados")
    Call<List<Candidatos>> listUsuario();

    @POST("users")
    Call<Usuario> createPost(@Body Usuario usuarioPOST);
}
