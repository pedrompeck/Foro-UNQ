package ar.edu.unq.ingdesoftware.model

class Materia(val id: Int, val name: String, val descripcion: String) {

    var publicaciones: MutableList<Publicacion> = mutableListOf()

    fun addPublicacion(publicacion : Publicacion) {
        this.publicaciones.add(publicacion)
    }

}
