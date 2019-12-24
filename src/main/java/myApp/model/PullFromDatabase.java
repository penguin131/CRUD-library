package myApp.model;

import myApp.utils.DbConfiguration;
import myApp.utils.HibernateUtil;
import org.apache.tomcat.jni.Error;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Get entities object for ID.
 */

public class PullFromDatabase {
	public static AuthorsEntity getAuthorForId(int authorID) throws Exception {
		AuthorsEntity author;
		try {
			EntityManager em = DbConfiguration.getEm();
			em.getTransaction().begin();
			author = (AuthorsEntity) em.createQuery("from AuthorsEntity where authorId="+authorID).getResultList().get(0);
			em.getTransaction().commit();
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new Exception(ex);
		}
		return author;
	}

	public static PublishingEntity getPublishingForId(int publishingId) throws Exception {
		PublishingEntity publishing;
		try {
			EntityManager em = DbConfiguration.getEm();
			em.getTransaction().begin();
			publishing = (PublishingEntity) em.createQuery("from PublishingEntity where publishingId="+publishingId).getResultList().get(0);
			em.getTransaction().commit();
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new Exception(ex);
		}
		return publishing;
	}

	public static BooksEntity getBookForId(int bookId) throws Exception {
		BooksEntity book;
		try {
			EntityManager em = DbConfiguration.getEm();
			em.getTransaction().begin();
			book = (BooksEntity) em.createQuery("from BooksEntity where bookId="+bookId).getResultList().get(0);
			em.getTransaction().commit();
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new Exception(ex);
		}
		return book;
	}
}
