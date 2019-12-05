package myApp.controllers.action;

import myApp.controllers.form.AddAuthorForm;
import myApp.model.AuthorsEntity;
import myApp.utils.HibernateUtil;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Add new author to dictionary. Author has only name.
 */
public class AddAuthorAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping,
								 ActionForm form,
								 HttpServletRequest request,
								 HttpServletResponse response) {
		AddAuthorForm addAuthorForm = (AddAuthorForm) form;
		final Session session = HibernateUtil.getHibernateSession();
		session.beginTransaction();
		AuthorsEntity authorToAdded = new AuthorsEntity();
		authorToAdded.setName(addAuthorForm.getName());
		session.save(authorToAdded);
		session.getTransaction().commit();
		session.close();
		return mapping.findForward("add");
	}
}
