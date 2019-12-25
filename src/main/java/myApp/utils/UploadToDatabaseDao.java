package myApp.utils;

import myApp.model.AuthorsEntity;
import myApp.model.BooksEntity;
import myApp.model.PublishingEntity;
import javax.ejb.*;
import javax.persistence.EntityManager;

@Stateless
public class UploadToDatabaseDao implements UploadInterfaceDao {
	public void commitAuthor(AuthorsEntity author) {
		EntityManager em = DbConfiguration.getEm();
		em.getTransaction().begin();
		em.persist(author);
		em.flush();
		em.getTransaction().commit();
	}

	public void commitPublishing(PublishingEntity publishing) {
		EntityManager em = DbConfiguration.getEm();
		em.getTransaction().begin();
		em.persist(publishing);
		em.flush();
		em.getTransaction().commit();
	}

	public void commitBook(BooksEntity book) {
		EntityManager em = DbConfiguration.getEm();
		em.getTransaction().begin();
		em.persist(book);
		em.flush();
		em.getTransaction().commit();
	}

	public static final String LocalJNDIName = UploadToDatabaseDao.class.getSimpleName()
			+ "Local";
}
