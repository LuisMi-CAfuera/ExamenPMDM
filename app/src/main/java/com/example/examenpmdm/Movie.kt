package com.example.examenpmdm

class Movie  {
    var id = 0
    var fav = false
    var titulo = ""
    var duracion = 0
    var nomDic = ""
    var anio = 0

    constructor(id : Int,fav :Boolean,titulo: String, duracion: Int, nomDic: String, anio: Int) {
        this.id = id
        this.fav = fav
        this.titulo = titulo
        this.duracion = duracion
        this.nomDic = nomDic
        this.anio = anio
    }

    constructor()

}

class Pelis{
    var pelis = ArrayList<Movie>()

    constructor(pelis: ArrayList<Movie>) {
        this.pelis = pelis
    }

    constructor()


}