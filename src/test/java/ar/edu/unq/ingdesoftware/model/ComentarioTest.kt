package ar.edu.unq.ingdesoftware.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ComentarioTest {

    lateinit var comentario: Comentario;

    @Test
    fun testConstructorComentario(){
        comentario = Comentario(1, "¿Donde puedo seguir informandome?")
        Assert.assertEquals(comentario.id, 1);
        Assert.assertEquals(comentario.mensaje, "¿Donde puedo seguir informandome?");
    }
}