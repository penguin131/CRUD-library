package myApp.controllers.action;

import myApp.controllers.form.EditBookForm;
import myApp.model.BooksEntity;
import myApp.model.PullFromDatabase;
import myApp.utils.HibernateUtil;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Select book from database for id and commit changes.
 */

public class EditBookAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping,
								 ActionForm form,
								 HttpServletRequest request,
								 HttpServletResponse response) throws Exception {
		EditBookForm editBookForm = (EditBookForm) form;
		final Session session = HibernateUtil.getHibernateSession();
		session.beginTransaction();
		try {
			BooksEntity currentBook = (BooksEntity) session
					.createQuery("from BooksEntity where bookId="+Integer.parseInt(editBookForm.getBookId()))
					.list()
					.get(0);
			if (editBookForm.getAuthor().length() > 0) {
				currentBook.setAuthor(PullFromDatabase.getAuthorForId(Integer.parseInt(editBookForm.getAuthor())));
			}
			if (editBookForm.getPublishing().length() > 0) {
				currentBook.setPublishing(PullFromDatabase.getPublishingForId(Integer.parseInt(editBookForm.getPublishing())));
			}
			if (editBookForm.getYear().length() > 0) {
				currentBook.setYear(Integer.parseInt(editBookForm.getYear()));
			}
			if (editBookForm.getCost().length() > 0) {
				currentBook.setCost(Float.parseFloat(editBookForm.getCost()));
			}
			if (editBookForm.getTitle().length() > 0) {
				currentBook.setTitle(editBookForm.getTitle());
			}
			session.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception(ex);
		}
		session.close();
		return mapping.findForward("edit");
	}
}
