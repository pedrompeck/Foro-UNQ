package ar.edu.unq.ingdesoftware.model

class Publicacion(val id: Int, val name: String, val descripcion: String) {

    var comentarios: MutableList<Comentario> = mutableListOf()

    fun addComentario(comentario: Comentario) {
        this.comentarios.add(comentario)
    }

}
