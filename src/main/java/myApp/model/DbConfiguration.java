package myApp.model;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * read config.xml from root directory and save params
 */

public class DbConfiguration {
//    static {
//        File file = new File("config.xml");
//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        try {
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(file);
//            doc.getDocumentElement().normalize();
//            userName = doc.getElementsByTagName("username").item(0).getTextContent();
//            password = doc.getElementsByTagName("password").item(0).getTextContent();
//            url = doc.getElementsByTagName("url").item(0).getTextContent();
//            connect = DriverManager.getConnection(getUrl(), getUserName(), getPassword());
//        } catch (Exception ex) {
//            throw new Error();
//        }
//    }
//
//    private static final String userName;
//    private static final String password;
//    private static final String url;
//    private static final Connection connect;
//
//    public static String getUserName() { return userName; }
//
//    public static String getPassword() { return password; }
//
//    public static String getUrl() { return url; }
//
//    public static Connection getConnect() {
//        return connect;
//    }
}
