package myApp.controllers;

import myApp.model.AuthorsEntity;
import myApp.model.PublishingEntity;
import myApp.utils.HibernateUtil;
import org.hibernate.Session;
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
		final Session session1 = HibernateUtil.getHibernateSession();
		session1.beginTransaction();
		authorList = (ArrayList<AuthorsEntity>) session1.createQuery("from AuthorsEntity order by name").list();
		publishingList = (ArrayList<PublishingEntity>) session1.createQuery("from PublishingEntity order by name").list();
		session1.close();
	}

	public static ArrayList<AuthorsEntity> getAuthorList() {
		return authorList;
	}

	public static ArrayList<PublishingEntity> getPublishingList() {
		return publishingList;
	}
}
