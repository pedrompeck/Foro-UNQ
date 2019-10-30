package ar.edu.unq.ingdesoftware.dao

import ar.edu.unq.ingdesoftware.dao.impl.HibernateUserDAO
import ar.edu.unq.ingdesoftware.model.User
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UserServiceTest {

    lateinit var userDAO: UserDAO;
    lateinit var user1: User;
    lateinit var user2: User;


    @Before
    fun prepare() {
        user1 = User(1,"Pepe", "1234");
        user2 = User(2,"Jose", "4321");
        userDAO = HibernateUserDAO();
    }

    @Test
    fun sePersisteUnUsuarioYSeLoRecuperaConExito() {

        userDAO.guardar(user1);

        var userRecuperado = userDAO.recuperar(1);
        assertEquals(user1.username, userRecuperado.username);
        assertEquals(user1.password, userRecuperado.password);

    }

    @Test
    fun sePersisteUnUsuarioYseRecuperaPorElNombreConExito() {

        userDAO.guardar(user1);

        var user1Recuperado = userDAO.recuperarPorNonmbre("Pepe");

        assertEquals(user1Recuperado.username, user1.username);
        assertEquals(user1Recuperado.password, user1.password);

    }

    @Test
    fun sePersistenDosUsuariosYseRecueperanTodos() {
        var listaDeUsuarios = mutableListOf<User>();
        listaDeUsuarios.add(user1);
        listaDeUsuarios.add(user2);

        userDAO.guardar((user1));
        userDAO.guardar((user2));

        assertTrue { listaDeUsuarios.containsAll(userDAO.getAll()) }

    }

    @After
    fun finish(){
        userDAO.finish();
    }



}