package ar.edu.unq.ingdesoftware.API_REST

import ar.edu.unq.ingdesoftware.model.Comentario
import ar.edu.unq.ingdesoftware.model.Foro
import ar.edu.unq.ingdesoftware.model.Materia
import ar.edu.unq.ingdesoftware.model.Publicacion
import ar.edu.unq.ingdesoftware.model.exceptions.MateriaNotFound
import ar.edu.unq.ingdesoftware.model.exceptions.PublicacionNotFound
import io.javalin.Context
import io.javalin.NotFoundResponse
import org.eclipse.jetty.http.HttpStatus
import org.eclipse.jetty.http.HttpStatus.CREATED_201
import org.eclipse.jetty.http.HttpStatus.OK_200

class ForoController(unForo: Foro) {

    val foro: Foro = unForo
    val conversor: Conversor = Conversor()
    var lastId: Int = 9

    fun getAllMaterias(ctx: Context) {
       val materiasREST: List<MateriaREST> = conversor.materiasToREST(foro.materias)
        ctx.json(materiasREST)
    }

    fun getMateriaById(ctx: Context) {
        val idMateria = ctx.pathParam("id").toInt()
        try {
            val materia: Materia = foro.getMateriaById(idMateria)
           val materiaREST: MateriaREST = conversor.materiaToREST(materia)
            ctx.json(materiaREST)
        }
        catch(e : MateriaNotFound) {
            throw NotFoundResponse("La materia con el id $idMateria no se encontro")
        }
    }

    fun getAllPublicacionesByName(ctx: Context) {
        val name: String = ctx.queryParam("q")!!
        val publicaciones: List<Publicacion> = foro.getAllPublicacionesByName(name.toLowerCase())
        ctx.json(publicaciones)
    }

    fun getPublicacionById(ctx: Context) {
        val idPublicacion = ctx.pathParam("id").toInt()
        try {
            val publicacion = foro.getPublicacionByid(idPublicacion)
            ctx.json(publicacion)
        }
        catch (e : PublicacionNotFound) {
            throw NotFoundResponse("La publicacion con el id $idPublicacion no existe")
        }
    }

    fun comentarPublicacionById(ctx: Context) {
        val idPublicacion = ctx.pathParam("id").toInt()
        val elComentario = ctx.body<ComentarioREST>()
        try {
            val publicacion = foro.getPublicacionByid(idPublicacion)
            publicacion.addComentario(Comentario (++this.lastId, elComentario.comentario))
            ctx.json(publicacion.comentarios)
        }
        catch (e : PublicacionNotFound) {
            throw NotFoundResponse("La publicacion con el id $idPublicacion no existe")
        }
    }
}
