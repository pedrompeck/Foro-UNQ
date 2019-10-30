package ar.edu.unq.ingdesoftware.model

import ar.edu.unq.ingdesoftware.model.exceptions.UserExistException

class Foro {

    var users: MutableList<User> = mutableListOf()

    fun addUser(user: User) {
        this.checkUser(user.username)
        this.users.add(user)
    }

    private fun checkUser(username: String) {
        var user = this.users.find { user -> user.username == username }
        if(user != null) {
            throw UserExistException("El usuario con el nombre $username ya existe")
        }
    }

}
