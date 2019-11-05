package ar.edu.unq.ingdesoftware.model

class Publicacion(val name: String, val descripcion: String) {

    var comentarios: MutableList<String> = mutableListOf()

    fun addComentario(comentario: String) {
        this.comentarios.add(comentario)
    }

}
