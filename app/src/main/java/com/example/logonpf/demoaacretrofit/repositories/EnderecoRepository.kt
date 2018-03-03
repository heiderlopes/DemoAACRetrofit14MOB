package com.example.logonpf.demoaacretrofit.repositories

import android.arch.lifecycle.LiveData
import com.example.logonpf.demoaacretrofit.entities.EnderecoResponse

interface EnderecoRepository {

    fun buscarEndereco(cep: String):
            LiveData<EnderecoResponse>

}