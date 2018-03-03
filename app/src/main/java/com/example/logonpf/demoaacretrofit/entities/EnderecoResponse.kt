package com.example.logonpf.demoaacretrofit.entities

class EnderecoResponse {
    var endereco: Endereco?
    var erro: Throwable?

    constructor(endereco: Endereco?) {
        this.endereco = endereco
        this.erro = null
    }

    constructor(erro: Throwable) {
        this.erro = erro
        this.endereco = null
    }

}