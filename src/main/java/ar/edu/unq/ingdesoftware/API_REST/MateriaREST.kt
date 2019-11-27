package ar.edu.unq.ingdesoftware.API_REST

import ar.edu.unq.ingdesoftware.model.Comentario
import ar.edu.unq.ingdesoftware.model.Publicacion

data class MateriaREST(val id: Int, val name: String, val descripcion: String, val nombresDePublicaciones: List<String>, val comentarios: List<List<Comentario>>)