package ar.edu.unq.ingdesoftware.model

import ar.edu.unq.ingdesoftware.model.exceptions.MateriaNotFound
import ar.edu.unq.ingdesoftware.model.exceptions.UserExistException
import java.util.stream.Collectors

class Foro {

    var users: MutableList<User> = mutableListOf()
    var materias: MutableList<Materia> = mutableListOf()

    fun addUser(user: User) {
        this.users.add(user)
    }

    fun addMateria(materia: Materia) {
        this.materias.add(materia)
    }

    fun checkUser(username: String): User {
        return this.users.find { user -> user.username == username } ?:
                throw UserExistException("Usuario o Contraseña Incorrectos")
    }

    fun getMateriaById(idMateria: Int): Materia {
        return this.materias.find { materia -> materia.id == idMateria } ?:
                throw MateriaNotFound("No se encontro la materia con id $idMateria")
    }

    fun getAllPublicacionesByName(name: String): List<Publicacion> {
        return this.getAllPublicaciones().filter{ publicacion -> publicacion.name == name }
    }

    fun getAllPublicaciones(): List<Publicacion> {
        return this.materias
                .map { materia -> materia.publicaciones }
                .flatMap{ publicaciones -> publicaciones }
    }


}
