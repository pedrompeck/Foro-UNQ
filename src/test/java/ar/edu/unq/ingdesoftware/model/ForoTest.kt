package ar.edu.unq.ingdesoftware.model
import ar.edu.unq.ingdesoftware.model.Foro
import ar.edu.unq.ingdesoftware.model.User
import ar.edu.unq.ingdesoftware.model.exceptions.UserExistException
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class ForoTest {

    lateinit var foro: Foro

    @Before
    fun setUp() {
        foro = Foro();
    }

    @Test
    fun testElForoNoTieneNingunUsuario() {
        assertEquals(0,foro.users.size)
    }

    @Test
    fun testSeAgregaUnUsuarioAlForo() {
        var user = User(1,"pity", "123")
        foro.addUser(user)
        assertEquals(1,foro.users.size)
    }
}