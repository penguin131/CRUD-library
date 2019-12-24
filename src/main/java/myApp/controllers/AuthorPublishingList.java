package myApp.controllers;

import myApp.model.AuthorsEntity;
import myApp.model.PublishingEntity;
import myApp.utils.DbConfiguration;
import myApp.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.ArrayList;

/**
 * Author and publishing lists for author forms.
 */

public class AuthorPublishingList {
	private static ArrayList<AuthorsEntity> authorList;
	private static ArrayList<PublishingEntity> publishingList;

	static {
		downloadLists();
	}

	@SuppressWarnings("unchecked")
	private static void downloadLists() {
		EntityManager em = DbConfiguration.getEm();
		em.getTransaction().begin();
		authorList = (ArrayList<AuthorsEntity>) em.createQuery("from AuthorsEntity").getResultList();
		publishingList = (ArrayList<PublishingEntity>) em.createQuery("from PublishingEntity").getResultList();
		em.getTransaction().commit();
	}

	public static ArrayList<AuthorsEntity> getAuthorList() {
		return authorList;
	}

	public static ArrayList<PublishingEntity> getPublishingList() {
		return publishingList;
	}
}
