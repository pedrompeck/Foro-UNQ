package ar.edu.unq.ingdesoftware.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MateriaTest {

    lateinit var materiaPersistencia: Materia;
    lateinit var publicacionHibernate: Publicacion;
    lateinit var publicacionReact: Publicacion;
    lateinit var publicacionJDBC: Publicacion;

    @Before
    fun setUp() {
        publicacionHibernate = Publicacion(1, "Hibernate", "Hibernate es una herramienta de mapeo objeto-relacional para la plataforma Java que facilita el mapeo de atributos entre una base de datos relacional tradicional y el modelo de objetos de una aplicación");
        publicacionReact = Publicacion(4,"React", "React es una biblioteca Javascript de código abierto diseñada para crear interfaces de usuario con el objetivo de facilitar el desarrollo de aplicaciones en una sola página. ");
        publicacionJDBC = Publicacion(2, "JDBC", "Java Database Connectivity (JDBC) es una interfase de acceso a bases de datos estándar SQL que proporciona un acceso uniforme a una gran variedad de bases de datos relacionales");
        materiaPersistencia = Materia(1, "Persistencia", " Es la acción de preservar la información de un objeto de forma permanente (guardado), pero a su vez también se refiere a poder recuperar la información del mismo (leerlo) para que pueda ser nuevamente utilizado.");

    }

    @Test
    fun unaMateriaRecibeUnaNuevaPublicacion() {

        materiaPersistencia.addPublicacion(publicacionHibernate);

        Assert.assertTrue(materiaPersistencia.publicaciones.contains(publicacionHibernate));
    }

    @Test
    fun unaMateriaListaLosNombreDeSusPublicaciones(){

        materiaPersistencia.addPublicacion(publicacionHibernate);
        materiaPersistencia.addPublicacion(publicacionJDBC);

        Assert.assertTrue(materiaPersistencia.nombresDePublicaciones().contains("Hibernate"));
        Assert.assertTrue(materiaPersistencia.nombresDePublicaciones().contains("JDBC"));
        Assert.assertFalse(materiaPersistencia.nombresDePublicaciones().contains("React"));

    }

}