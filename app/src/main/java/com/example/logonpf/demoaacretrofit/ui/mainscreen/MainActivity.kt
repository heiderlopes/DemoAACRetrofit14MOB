package com.example.logonpf.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.logonpf.demoaacretrofit.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(
                this).get(MainViewModel::class.java)

        btPesquisar.setOnClickListener {
            mainViewModel.pesquisarEndereco(etCEP.text.toString())
        }
        mainViewModel.apiResponse.observe(this, Observer { apiResponse ->
            if (apiResponse?.erro == null) {
                val end = apiResponse?.endereco
                tvResultado.text =
                        "Logradouro: ${end?.logradouro}\n" +
                                "Complemento: ${end?.complemento}" +
                                "Bairro: ${end?.bairro}" +
                                "Localidade: ${end?.localidade}" +
                                "UF: ${end?.uf}"
            } else {
                Log.i("TAG", "ERRO: ${apiResponse.erro} ...")
            }
        })

        mainViewModel.isLoading.observe(this,
                Observer { isLoading ->
                    if (isLoading!!) {
                        loading.visibility = View.VISIBLE
                    } else {
                        loading.visibility = View.GONE
                    }
                })


    }
}










