package myApp.model;

import myApp.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class PullDatabase {
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
		List publishings = session
				.createQuery("from PublishingEntity where publishingID="+publishingId)
				.list();
		if (publishings.size() > 0) {
			publishing = (PublishingEntity) publishings.get(0);
		}
		session.close();
		return publishing;
	}
}
