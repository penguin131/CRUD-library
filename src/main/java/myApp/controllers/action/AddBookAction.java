package myApp.controllers.action;

import myApp.controllers.form.AddBookForm;
import myApp.model.AuthorsEntity;
import myApp.model.BooksEntity;
import myApp.model.PublishingEntity;
import myApp.model.PullFromDatabase;
import myApp.utils.DbConfiguration;
import myApp.utils.HibernateUtil;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Add new book to database. Author and publishing from database.
 */

public class AddBookAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping,
								 ActionForm form,
								 HttpServletRequest request,
								 HttpServletResponse response) throws Exception {
		AddBookForm addBookForm = (AddBookForm) form;
		EntityManager em = DbConfiguration.getEm();

		BooksEntity bookToAdded = new BooksEntity();
		AuthorsEntity author = PullFromDatabase.getAuthorForId(Integer.parseInt(addBookForm.getAuthor()));
		PublishingEntity publishing = PullFromDatabase.getPublishingForId(Integer.parseInt(addBookForm.getPublishing()));
		bookToAdded.setTitle(addBookForm.getTitle());
		bookToAdded.setCost(Float.parseFloat(addBookForm.getCost()));
		bookToAdded.setYear(Integer.parseInt(addBookForm.getYear()));
		bookToAdded.setAuthor(author);
		bookToAdded.setPublishing(publishing);
		em.getTransaction().begin();
		em.persist(bookToAdded);
		em.flush();
		em.getTransaction().commit();
		return mapping.findForward("add");
	}
}
