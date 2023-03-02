package com.example.examenpmdm

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examenpmdm.databinding.ActivityMovieDisplayBinding
import com.google.gson.Gson

class MovieDisplayActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMovieDisplayBinding
    @SuppressLint("CommitPrefEdits", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val shared = getSharedPreferences("Peli", Context.MODE_PRIVATE)
        val gson = Gson()
        val editor = shared.edit()
        var json = shared.getString("Peli", "")
        val peli = gson.fromJson(json, Movie::class.java)

        binding.textView.text = "Titulo:" +peli.titulo + "\nDuracion" +peli.duracion+ "\nDirector:"+peli.nomDic+ "\n Año" + peli.anio




        binding.Atras.setOnClickListener{
            val intent = Intent(this@MovieDisplayActivity,MovieDetailsActivity::class.java)
            json = gson.toJson(peli)
            editor.putString("Peli",json)
            editor.apply()
            startActivity(intent)
        }

        binding.OtraPeli.setOnClickListener{
            val intent = Intent(this@MovieDisplayActivity,MovieTitleActivity::class.java)
            startActivity(intent)
        }


    }
}