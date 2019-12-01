package ar.edu.unq.ingdesoftware.model

class Materia(val id: Int, val name: String, val descripcion: String) {

    var publicaciones: MutableList<Publicacion> = mutableListOf()

    fun addPublicacion(publicacion : Publicacion) {
        this.publicaciones.add(publicacion)
    }

    fun nombresDePublicaciones(): List<String> {
        return this.publicaciones.map{ publicacion -> publicacion.name }
    }

    fun comentariosPorPublicacion(): List<List<Comentario>> {
        val result: MutableList<MutableList<Comentario>> = mutableListOf()
        this.publicaciones.map{ publicacion -> result.add(publicacion.comentarios) }
        return result
    }

}
