package myApp.controllers.action;

import myApp.controllers.form.DeleteBookForm;
import myApp.model.BooksEntity;
import myApp.utils.HibernateUtil;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Delete book from database for id
 */

public class DeleteBookAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping,
								 ActionForm form,
								 HttpServletRequest request,
								 HttpServletResponse response) {
		DeleteBookForm deleteBookForm = (DeleteBookForm) form;
		final Session session = HibernateUtil.getHibernateSession();
		session.beginTransaction();
		BooksEntity book = session.load(BooksEntity.class, Integer.parseInt(deleteBookForm.getBookId()));
		session.delete(book);
		session.getTransaction().commit();
		session.close();
		return mapping.findForward("delete");
	}
}
