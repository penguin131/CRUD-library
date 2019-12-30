package myApp.utils;

import myApp.model.AuthorsEntity;
import myApp.model.BooksEntity;
import myApp.model.PublishingEntity;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PullFromDatabaseTest {
	private EntityManager em;

	PullFromDatabaseTest()
	{
		File file = new File("config.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			String userName;
			String password;
			String url;
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			userName = doc.getElementsByTagName("username").item(0).getTextContent();
			password = doc.getElementsByTagName("password").item(0).getTextContent();
			url = doc.getElementsByTagName("url").item(0).getTextContent();
			Map<String, Object> prop = new HashMap<String, Object>();
			prop.put("hibernate.connection.username", userName);
			prop.put("hibernate.connection.password", password);
			prop.put("hibernate.connection.url", url);
			EntityManagerFactory ef = Persistence.createEntityManagerFactory("Library", prop);
			em = ef.createEntityManager();
		} catch (Exception ex) {
			throw new Error(ex);
		}
	}

	@Test
	void getAuthorForIdTest() {
		em.getTransaction().begin();
		try {
			AuthorsEntity author = new AuthorsEntity();
			author.setName("one");
			em.persist(author);
			em.flush();
			AuthorsEntity downloadedAuthor = (AuthorsEntity) em
					.createQuery("from AuthorsEntity where name='one' order by authorId desc")
					.getResultList()
					.get(0);
			assertEquals(author, downloadedAuthor);
		} finally {
			em.getTransaction().rollback();
		}
	}

	@Test
	void getPublishingForIdTest() {
		em.getTransaction().begin();
		try {
			PublishingEntity publishing = new PublishingEntity();
			publishing.setName("one");
			em.persist(publishing);
			em.flush();
			PublishingEntity downloadedPublishing = (PublishingEntity) em
					.createQuery("from PublishingEntity where name='one' order by publishingId desc")
					.getResultList()
					.get(0);
			assertEquals(publishing, downloadedPublishing);
		} finally {
			em.getTransaction().rollback();
		}
	}

	@Test
	void getBookForIdTest() {
		em.getTransaction().begin();
		try {
			AuthorsEntity author = new AuthorsEntity();
			author.setName("one");
			PublishingEntity publishing = new PublishingEntity();
			publishing.setName("one");
			BooksEntity book = new BooksEntity();
			book.setPublishing(publishing);
			book.setAuthor(author);
			book.setTitle("one");
			em.persist(author);
			em.persist(publishing);
			em.persist(book);
			em.flush();
			BooksEntity downloadedBook = (BooksEntity) em
					.createQuery("from BooksEntity where title='one' order by bookId desc")
					.getResultList()
					.get(0);
			assertEquals(book, downloadedBook);
		} finally {
			em.getTransaction().rollback();
		}
	}

	@Test
	void getBooksTest() {
		em.getTransaction().begin();
		try {
			AuthorsEntity author = new AuthorsEntity();
			author.setName("one");
			PublishingEntity publishing = new PublishingEntity();
			publishing.setName("one");
			BooksEntity book1 = new BooksEntity();
			BooksEntity book2 = new BooksEntity();
			book1.setPublishing(publishing);
			book1.setAuthor(author);
			book1.setTitle("one");
			book2.setPublishing(publishing);
			book2.setAuthor(author);
			book2.setTitle("one");
			em.persist(author);
			em.persist(publishing);
			em.persist(book1);
			em.persist(book2);
			em.flush();
			List downloadedBooks = em
					.createQuery("from BooksEntity where title='one' order by bookId desc")
					.getResultList();
			assertEquals(downloadedBooks.size(), 2);
			assertEquals(downloadedBooks.get(0), book2);
			assertEquals(downloadedBooks.get(1), book1);
		} finally {
			em.getTransaction().rollback();
		}
	}
}
