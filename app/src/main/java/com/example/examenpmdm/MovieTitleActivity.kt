package com.example.examenpmdm

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.examenpmdm.databinding.ActivityMainBinding
import com.google.gson.Gson

class MovieTitleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Pasar.isEnabled = false
        val shared = getSharedPreferences("Peli", Context.MODE_PRIVATE)
        val gson = Gson()
        val editor = shared.edit()
        val peli = Movie()





        binding.Titulo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                peli.titulo = binding.Titulo.text.toString()
            }
            override fun afterTextChanged(s: Editable?) {

            }
        })

        binding.Duracion.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                peli.duracion = binding.Duracion.text.toString().toInt()
            }
            override fun afterTextChanged(s: Editable?) {
                if(binding.Titulo.text.toString() != "" && binding.Duracion.text.toString().toInt() != 0){
                    binding.Pasar.isEnabled = true

                }

            }
        })



        binding.Pasar.setOnClickListener{
            val intent = Intent(this@MovieTitleActivity, MovieDetailsActivity::class.java)
            var json = gson.toJson(peli)
            editor.putString("Peli",json)
            editor.apply()
            startActivity(intent)
        }


    }
}