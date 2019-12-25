package myApp.controllers.action;

import myApp.controllers.form.AddBookForm;
import myApp.model.*;
import myApp.utils.PullFromDatabase;
import myApp.utils.UploadInterfaceDao;
import myApp.utils.UploadToDatabaseDao;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * Add new book to database. Author and publishing from database.
 */

public class AddBookAction extends Action {
	private UploadInterfaceDao uploadToDatabase;

	@Override
	public ActionForward execute(ActionMapping mapping,
								 ActionForm form,
								 HttpServletRequest request,
								 HttpServletResponse response) throws Exception {
		AddBookForm addBookForm = (AddBookForm) form;
		BooksEntity bookToAdded = new BooksEntity();

		AuthorsEntity author = PullFromDatabase.getAuthorForId(Integer.parseInt(addBookForm.getAuthor()));
		PublishingEntity publishing = PullFromDatabase.getPublishingForId(Integer.parseInt(addBookForm.getPublishing()));
		bookToAdded.setTitle(addBookForm.getTitle());
		bookToAdded.setCost(Float.parseFloat(addBookForm.getCost()));
		bookToAdded.setYear(Integer.parseInt(addBookForm.getYear()));
		bookToAdded.setAuthor(author);
		bookToAdded.setPublishing(publishing);
		uploadToDatabase.commitBook(bookToAdded);
		return mapping.findForward("add");
	}

	public AddBookAction() {
		try
		{
			Properties properties = new Properties();
			properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.core.LocalInitialContextFactory");
			Context context = new InitialContext(properties);
			uploadToDatabase = (UploadInterfaceDao) context
					.lookup(UploadToDatabaseDao.LocalJNDIName);
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
