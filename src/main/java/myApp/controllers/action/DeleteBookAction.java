package myApp.controllers.action;

import myApp.controllers.form.DeleteBookForm;
import myApp.model.BooksEntity;
import myApp.utils.DbConfiguration;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.persistence.EntityManager;
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
		EntityManager em = DbConfiguration.getEm();
		BooksEntity delBook = em.find(BooksEntity.class, Integer.parseInt(deleteBookForm.getBookId()));
		em.getTransaction().begin();
		em.remove(delBook);
		em.getTransaction().commit();
		return mapping.findForward("delete");
	}
}
