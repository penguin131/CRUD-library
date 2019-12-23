package myApp.model;

import myApp.utils.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

/**
 * Get entities object for ID.
 */

public class PullFromDatabase {
	public static AuthorsEntity getAuthorForId(int authorID) {
		final Session session = HibernateUtil.getHibernateSession();
		session.beginTransaction();
		AuthorsEntity author = null;
		List authors = session
				.createQuery("from AuthorsEntity where authorID=" + authorID)
				.list();
		if (authors.size() > 0) {
			author = (AuthorsEntity) authors.get(0);
		}
		session.close();
		return author;
	}

	public static PublishingEntity getPublishingForId(int publishingId) {
		final Session session = HibernateUtil.getHibernateSession();
		session.beginTransaction();
		PublishingEntity publishing = null;
		List pubs = session
				.createQuery("from PublishingEntity where publishingID="+publishingId)
				.list();
		if (pubs.size() > 0) {
			publishing = (PublishingEntity) pubs.get(0);
		}
		session.close();
		return publishing;
	}

	public static BooksEntity getBookForId(int bookId) {
		final Session session = HibernateUtil.getHibernateSession();
		session.beginTransaction();
		BooksEntity book = null;
		List books = session
				.createQuery("from BooksEntity where bookId="+bookId)
				.list();
		if (books.size() > 0) {
			book = (BooksEntity) books.get(0);
		}
		session.close();
		return book;
	}
}
