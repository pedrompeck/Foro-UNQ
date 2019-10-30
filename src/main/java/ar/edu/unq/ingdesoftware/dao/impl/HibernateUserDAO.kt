package ar.edu.unq.ingdesoftware.dao.impl

import ar.edu.unq.ingdesoftware.dao.UserDAO
import ar.edu.unq.ingdesoftware.model.User
import ar.edu.unq.ingdesoftware.service.runner.SessionFactoryProvider

class HibernateUserDAO : UserDAO {

    var manager = SessionFactoryProvider();
    var session = manager.getSession();
    var tx = session.beginTransaction();

    override fun recuperarPorNonmbre(userName: String): User {

        var hql = "from User i"
        "where i.username = :userName";
        var query = session.createQuery(hql, User::class.java);
        var userRecuperado = query.resultList.get(0);

        return userRecuperado;
    }

    override fun recuperar(id: Int): User {

        var userRecuperado = session.get(User::class.java, id);

        return userRecuperado;
    }

    override fun getAll(): MutableList<User> {

        var hql = "from User i";
        var query = session.createQuery(hql, User::class.java);
        var allUsers = query.resultList;

        return allUsers;
    }

    override fun guardar(user: User) {

        session.save(user);
    }

    override fun finish() {
        tx.commit();
        session.close();
    }


}