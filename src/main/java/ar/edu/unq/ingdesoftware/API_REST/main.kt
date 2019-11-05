package ar.edu.unq.ingdesoftware.API_REST

import ar.edu.unq.ingdesoftware.model.Foro
import ar.edu.unq.ingdesoftware.model.Materia
import ar.edu.unq.ingdesoftware.model.User
import com.fasterxml.jackson.databind.exc.MismatchedInputException
import io.javalin.Javalin
import org.eclipse.jetty.http.HttpStatus
import io.javalin.apibuilder.ApiBuilder.*
import org.eclipse.jetty.http.HttpStatus.OK_200
import java.time.LocalDate


fun main() {

    val app = Javalin.create()
            .enableRouteOverview("/routes")
            .exception(MismatchedInputException::class.java) { e, ctx ->
                ctx.status(HttpStatus.BAD_REQUEST_400)
                ctx.json(mapOf(
                        "status" to HttpStatus.BAD_REQUEST_400,
                        "message" to e.message
                ))
            }
            .enableCorsForAllOrigins()
            .start(7000)

    /** SETUP **/

    var foro = Foro()
    foro.addMateria(Materia(1, "Interfaces", "Es una materia de la UNQ para hacer diseño web"))
    foro.addMateria(Materia(2, "Persistencia", "Es una materia de la UNQ para persistir objectos"))

    val foroController = ForoController(foro)

    app.routes {
        path("materias") {
            get(foroController::getAllMaterias)
        }
    }

}