package ar.edu.unq.ingdesoftware.API_REST

import ar.edu.unq.ingdesoftware.model.*
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
    val interfaces = Materia(1, "Interfaces", "La interfaz de usuario es el medio con que el usuario puede comunicarse con una máquina, equipo, computadora o dispositivo, y comprende todos los puntos de contacto entre el usuario y el equipo.")
    val persistencia = Materia(2, "Persistencia", " Es la acción de preservar la información de un objeto de forma permanente (guardado), pero a su vez también se refiere a poder recuperar la información del mismo (leerlo) para que pueda ser nuevamente utilizado.")
    val ingDeSoftware = Materia(3, "Ingeneria de software", "La ingeniería de software es la aplicación de un enfoque sistemático, disciplinado y cuantificable al desarrollo, operación y mantenimiento de software y el estudio de estos enfoques, es decir, el estudio de las aplicaciones de la ingeniería al software.")

    val react = Publicacion(4,"react", "React es una biblioteca Javascript de código <abierto diseñada para crear interfaces de usuario con el objetivo de facilitar el desarrollo de aplicaciones en una sola página. ")
    val hibernate = Publicacion( 5,"hibernate", "Hibernate es una herramienta de mapeo objeto-relacional para la plataforma Java que facilita el mapeo de atributos entre una base de datos relacional tradicional y el modelo de objetos de una aplicación")
    val scrum = Publicacion(6, "scrum","Scrum es un proceso en el que se aplican de manera regular un conjunto de buenas prácticas para trabajar colaborativamente, en equipo, y obtener el mejor resultado posible de un proyecto.")

    val userAdmin = User(10, "admin", "1234")

    react.addComentario(Comentario(7, "Recomiendo cursar esta materia, es muy interesante!"))
    hibernate.addComentario(Comentario(8, "Como se persiste en hibernate?"))
    scrum.addComentario(Comentario(9, "Asi se trabaja en la industria"))

    interfaces.addPublicacion(react)
    persistencia.addPublicacion(hibernate)
    ingDeSoftware.addPublicacion(scrum)

    foro.addMateria(interfaces)
    foro.addMateria(persistencia)
    foro.addMateria(ingDeSoftware)
    foro.addUser(userAdmin)

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

        path("login") {
            post(foroController::getUsuarioByName)
        }

        path("publicacion") {
            path(":id") {
                get(foroController::getPublicacionById)
            }
            path("comentar") {
                path(":id") {
                    post(foroController::comentarPublicacionById)
                }
            }
        }
    }

}