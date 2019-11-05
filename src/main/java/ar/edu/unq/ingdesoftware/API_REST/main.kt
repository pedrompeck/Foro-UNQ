package ar.edu.unq.ingdesoftware.API_REST

import ar.edu.unq.ingdesoftware.model.Foro
import ar.edu.unq.ingdesoftware.model.Materia
import ar.edu.unq.ingdesoftware.model.Publicacion
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
    val interfaces = Materia(1, "Interfaces", "Es una materia de la UNQ para hacer diseño web")
    val persistencia = Materia(2, "Persistencia", "Es una materia de la UNQ para persistir objectos")

    interfaces.addPublicacion(Publicacion("reactjs", "una herramienta para hacer el front end"))
    persistencia.addPublicacion(Publicacion("hibernate", "una herramienta para persistir objetos en la base de datos"))

    foro.addMateria(interfaces)
    foro.addMateria(persistencia)

    val foroController = ForoController(foro)

    app.routes {
        path("materias") {
            get(foroController::getAllMaterias)
            path(":id") {
                get(foroController::getMateriaById)
            }
        }

        path("search") {
            get(foroController::getAllPublicacionesByName)
        }
    }
}