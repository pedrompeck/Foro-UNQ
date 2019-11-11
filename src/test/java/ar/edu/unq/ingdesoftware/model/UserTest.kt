package ar.edu.unq.ingdesoftware.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UserTest {

    lateinit var usuario: User;

    @Before
    fun setUp(){
        usuario = User(1, "Pepe", "pepe123");
    }

    @Test
    fun testConstructorUsuario(){
        Assert.assertEquals(usuario.username, "Pepe");
        Assert.assertEquals(usuario.id, 1);
        Assert.assertEquals(usuario.password, "pepe123");
    }

    @Test
    fun seModificaElNombreDeUnUsuario(){
        usuario.setUserName("Jose");

        Assert.assertEquals("Jose", usuario.username);
    }

}