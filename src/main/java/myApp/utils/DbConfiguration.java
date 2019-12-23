package myApp.utils;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

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
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    private static final String userName;
    private static final String password;
    private static final String url;

    public static String getUserName() { return userName; }

    public static String getPassword() { return password; }

    public static String getUrl() { return url; }
}
