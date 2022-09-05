package com.novamerica.safetouractivity.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CEPService {
    @GET("{cep}/json/")
    Call<CEP> recuperarCEP(@Path("cep") String cep);

    @GET("/fotos")
    Call<CEP> recuperarFotos();
}
