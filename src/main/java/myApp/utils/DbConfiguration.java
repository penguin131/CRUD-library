package myApp.utils;

import org.w3c.dom.Document;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * read config.xml from root directory and save params
 */

public class DbConfiguration {
    static {
        File file = new File("../classes/config.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            userName = doc.getElementsByTagName("username").item(0).getTextContent();
            password = doc.getElementsByTagName("password").item(0).getTextContent();
            url = doc.getElementsByTagName("url").item(0).getTextContent();
			Map<String, Object> prop = new HashMap<String, Object>();
			prop.put("hibernate.connection.username", getUserName());
			prop.put("hibernate.connection.password", getPassword());
			prop.put("hibernate.connection.url", getUrl());
            EntityManagerFactory ef = Persistence.createEntityManagerFactory("Library", prop);
            em = ef.createEntityManager();
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    private static final String userName;
    private static final String password;
    private static final String url;
    private static EntityManager em;

    public static String getUserName() { return userName; }

    public static String getPassword() { return password; }

    public static String getUrl() { return url; }

    public static EntityManager getEm() { return em; }
}
