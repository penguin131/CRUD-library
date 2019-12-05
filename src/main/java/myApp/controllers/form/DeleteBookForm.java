package myApp.controllers.form;

import myApp.model.PullFromDatabase;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

/**
 * Read book id from form
 */

public class DeleteBookForm extends org.apache.struts.action.ActionForm {
	private String bookId;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
								 HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
		try {
			PullFromDatabase.getBookForId(Integer.parseInt(bookId));
		} catch (Exception ex) {
			errors.add("wtf", new ActionMessage("wtf"));
		}
		return errors;
	}
}
