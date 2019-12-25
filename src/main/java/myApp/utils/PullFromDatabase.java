package myApp.utils;

import myApp.model.AuthorsEntity;
import myApp.model.BooksEntity;
import myApp.model.PublishingEntity;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Get entities object for ID.
 */

@Transactional
public class PullFromDatabase {
	public static AuthorsEntity getAuthorForId(int authorID) throws Exception {
		AuthorsEntity author;
		EntityManager em = DbConfiguration.getEm();
		try {
			author = (AuthorsEntity) em
					.createQuery("from AuthorsEntity where authorId="+authorID)
					.getResultList().get(0);
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new Exception(ex);
		}
		return author;
	}

	public static PublishingEntity getPublishingForId(int publishingId) throws Exception {
		PublishingEntity publishing;
		EntityManager em = DbConfiguration.getEm();
		try {
			publishing = (PublishingEntity) em
					.createQuery("from PublishingEntity where publishingId="+publishingId)
					.getResultList().get(0);
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new Exception(ex);
		}
		return publishing;
	}

	public static BooksEntity getBookForId(int bookId) throws Exception {
		BooksEntity book;
		EntityManager em = DbConfiguration.getEm();
		try {
			book = (BooksEntity) em
					.createQuery("from BooksEntity where bookId="+bookId)
					.getResultList().get(0);
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new Exception(ex);
		}
		return book;
	}

	public static List getBooks() throws Exception {
		List books;
		EntityManager em = DbConfiguration.getEm();
		try {
			books = em.createQuery("from BooksEntity")
					.getResultList();
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new Exception(ex);
		}
		return books;
	}
}
