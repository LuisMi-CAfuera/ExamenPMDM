package com.example.examenpmdm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.examenpmdm.databinding.ActivityMovieDetailsBinding
import com.google.gson.Gson

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.isEnabled = false
        val shared = getSharedPreferences("Peli", Context.MODE_PRIVATE)
        val gson = Gson()
        val editor = shared.edit()
        var json = shared.getString("Peli", "")
        val peli = gson.fromJson(json, Movie::class.java)




        binding.Nombre.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                peli.nomDic = binding.Nombre.text.toString()

            }
            override fun afterTextChanged(s: Editable?) {

            }
        })

        binding.Anio.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                peli.anio = binding.Anio.text.toString().toInt()

            }
            override fun afterTextChanged(s: Editable?) {
                if(binding.Nombre.text.toString() != "" && binding.Anio.text.toString().toInt() != 0){
                    binding.button.isEnabled = true
                }

            }
        })

        binding.button.setOnClickListener{
            val intent = Intent(this@MovieDetailsActivity, MovieDisplayActivity::class.java)
            json = gson.toJson(peli)
            editor.putString("Peli",json)
            editor.apply()
            startActivity(intent)
        }
        binding.Volver.setOnClickListener{
            val intent = Intent(this@MovieDetailsActivity, MovieTitleActivity::class.java)
            json = gson.toJson(peli)
            editor.putString("Peli",json)
            editor.apply()
            startActivity(intent)
        }
    }
}