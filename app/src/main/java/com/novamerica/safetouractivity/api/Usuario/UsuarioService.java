package com.novamerica.safetouractivity.api.Usuario;

import com.novamerica.safetouractivity.vo.Usuarios.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;


public interface UsuarioService {
    public static final String BASE_URL = "https://gnaoic-hml-grkui1tjnnhj-gr.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/BUSCARCOLABORADORBYCPFANDSENHA/1.0/";

    @GET("?tipo_integracao=INTEGRA_COLABORADOR")
    Call<List<Usuario>> recuperarUsuarios(@Header ("Authorization") String authHeader);//, @Query("tipoIntegracao") String tipoIntegracao
}
