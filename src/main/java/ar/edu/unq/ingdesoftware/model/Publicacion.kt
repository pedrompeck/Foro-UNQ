package ar.edu.unq.ingdesoftware.model

class Publicacion {

    var comentarios: MutableList<String> = mutableListOf()

    fun addComentario(comentario: String) {
        this.comentarios.add(comentario)
    }

}
