package com.example.logonpf.demoaacretrofit.api

import com.example.logonpf.demoaacretrofit.entities.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EnderecoAPI {

    @GET("/ws/{cep}/json")
    fun pesquisar(@Path("cep")cep: String): Call<Endereco>

}