    package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

    class ResultActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_result)

            supportActionBar?.setHomeButtonEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)


            val tvResult = findViewById<TextView>(R.id.textview_result)
            val tvClassificao = findViewById<TextView>(R.id.textview_classificacao)


            val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)
            val formattedResult = String.format("%.1f", result)
            tvResult.text = formattedResult /*result.toString() */

            /*	Menor que 18,5	Baixo peso
       De 18,5 a 24,9	Peso normal
       De 25 a 29,9	Sobrepeso
       De 30 a 34,9	Obesidade grau I
       De 35 a 39.9	Obesidade grau II
       Igual ou maior que 40	Obesidade grau III
        */

            val classificacao = if (result < 18.5f){
                " ABAIXO DO PESO"
            }else if(result in 18.5f..24.9f){
                " PESO NORMAL"
            }else if(result in 25f..29.9f){
                " SOBREPESO"
            }else if(result in 30f..34.9F){
                "OBESIDADE GRAU 1"
            }else if(result in 35f..39.9f){
                "OBESIDADE GRAU 2"
            }else {
                "OBESIDADE GRAU 3"
            }
            tvClassificao.text = getString(R.string.message_classificacao,classificacao)
    }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            finish()
            return super.onOptionsItemSelected(item)
        }
}