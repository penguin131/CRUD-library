package myApp.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration()
                        .configure()
                        .buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static Session getHibernateSession() {
        Configuration configuration = new Configuration().configure("old/hibernate.cfg.xml");
        Properties properties = configuration.getProperties();
        properties.setProperty("hibernate.connection.password", DbConfiguration.getPassword());
        properties.setProperty("hibernate.connection.username", DbConfiguration.getUserName());
        properties.setProperty("hibernate.connection.url", DbConfiguration.getUrl());
//        properties.setProperty("hibernate.connection.password", "sa");
//        properties.setProperty("hibernate.connection.username", "sa");
//        properties.setProperty("hibernate.connection.url", "jdbc:h2:tcp://localhost/~/test");
        final SessionFactory sf = configuration.buildSessionFactory();
        return sf.openSession();
    }

    public static void shutdown() {
        sessionFactory.close();
    }
}
