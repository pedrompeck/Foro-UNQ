package ar.edu.unq.ingdesoftware.dao

import ar.edu.unq.ingdesoftware.model.User

interface UserDAO {

    fun guardar(user: User);

    fun recuperar(id: Int): User;

    fun recuperarPorNonmbre(userName: String): User;

    fun getAll(): MutableList<User>;

    fun finish();

}