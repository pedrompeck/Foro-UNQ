package ar.edu.unq.ingdesoftware.service.runner

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


class SessionFactoryProvider {

    fun getSession(): Session {
        val cfg = Configuration();
        cfg.configure("hibernate.cfg.xml");
        return cfg.buildSessionFactory().openSession();
    }

}