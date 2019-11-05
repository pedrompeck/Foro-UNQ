package ar.edu.unq.ingdesoftware.API_REST

import ar.edu.unq.ingdesoftware.model.Foro
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

}
