package ar.edu.unq.ingdesoftware.model

import ar.edu.unq.ingdesoftware.model.exceptions.MateriaNotFound
import ar.edu.unq.ingdesoftware.model.exceptions.UserExistException
import java.util.stream.Collectors

class Foro {

    var users: MutableList<User> = mutableListOf()
    var materias: MutableList<Materia> = mutableListOf()

    fun addUser(user: User) {
        this.checkUser(user.username)
        this.users.add(user)
    }

    fun addMateria(materia: Materia) {
        this.materias.add(materia)
    }

    private fun checkUser(username: String) {
        var user = this.users.find { user -> user.username == username }
        if(user != null) {
            throw UserExistException("El usuario con el nombre $username ya existe")
        }
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
