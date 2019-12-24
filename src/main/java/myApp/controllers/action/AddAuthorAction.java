package myApp.controllers.action;

import myApp.controllers.AuthorPublishingList;
import myApp.controllers.form.AddAuthorForm;
import myApp.model.AuthorsEntity;
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
import java.io.UnsupportedEncodingException;

/**
 * Add new author to dictionary. Author has only name.
 */

public class AddAuthorAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping,
								 ActionForm form,
								 HttpServletRequest request,
								 HttpServletResponse response) throws UnsupportedEncodingException {
		AddAuthorForm addAuthorForm = (AddAuthorForm) form;

		AuthorsEntity authorToAdded = new AuthorsEntity();
		authorToAdded.setName(addAuthorForm.getName());
		EntityManager em = DbConfiguration.getEm();
		em.getTransaction().begin();
		em.persist(authorToAdded);
		em.flush();
		em.getTransaction().commit();

		AuthorPublishingList.getAuthorList().add(authorToAdded);
		return mapping.findForward("add");
	}
}
