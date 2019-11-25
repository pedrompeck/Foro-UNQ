package ar.edu.unq.ingdesoftware.API_REST

import ar.edu.unq.ingdesoftware.model.Foro
import ar.edu.unq.ingdesoftware.model.Materia
import ar.edu.unq.ingdesoftware.model.Publicacion
import ar.edu.unq.ingdesoftware.model.exceptions.MateriaNotFound
import ar.edu.unq.ingdesoftware.model.exceptions.UserExistException
import io.javalin.Context
import io.javalin.NotFoundResponse
import org.eclipse.jetty.http.HttpStatus
import org.eclipse.jetty.http.HttpStatus.CREATED_201
import org.eclipse.jetty.http.HttpStatus.OK_200

class ForoController(unForo: Foro) {

    val foro: Foro = unForo
    val conversor: Conversor = Conversor()

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

    fun getUsuarioByName(ctx: Context) {
        val usuarioREST = ctx.body<UsuarioREST>()

        try {
            foro.checkUser(usuarioREST.username)
        } catch (e: UserExistException) {
            throw NotFoundResponse("Nombre Incorrecto")
        }

        val usuario = foro.checkUser(usuarioREST.username)
        if (usuario.password != usuarioREST.password) {
            throw NotFoundResponse("Contraseña Incorrecta")
        }
        
        ctx.status(OK_200)
        ctx.json(usuarioREST)
    }
}
