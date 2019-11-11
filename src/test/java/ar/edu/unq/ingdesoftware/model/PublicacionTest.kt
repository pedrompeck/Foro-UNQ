package ar.edu.unq.ingdesoftware.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PublicacionTest {

    lateinit var publicacion: Publicacion;
    lateinit var comentario: Comentario;

    @Before
    fun setUp(){

        publicacion = Publicacion(1, "Hibernate", "Hibernate es una herramienta de mapeo objeto-relacional para la plataforma Java que facilita el mapeo de atributos entre una base de datos relacional tradicional y el modelo de objetos de una aplicación")

        comentario = Comentario(1, "¿Como configuro Hibernate?");
    }

    @Test
    fun testConstructorPublicacion(){

        Assert.assertEquals(publicacion.id, 1);
        Assert.assertEquals(publicacion.name, "Hibernate");
        Assert.assertEquals(publicacion.descripcion, "Hibernate es una herramienta de mapeo objeto-relacional para la plataforma Java que facilita el mapeo de atributos entre una base de datos relacional tradicional y el modelo de objetos de una aplicación");
    }

    @Test
    fun unaPublicacionRecibeUnNuevoComentario(){

        publicacion.addComentario(comentario);

        Assert.assertTrue(publicacion.comentarios.contains(comentario));
    }
}