package myApp.controllers.action;

import myApp.controllers.AuthorPublishingList;
import myApp.controllers.form.AddAuthorForm;
import myApp.model.AuthorsEntity;
import myApp.utils.UploadInterfaceDao;
import myApp.utils.UploadToDatabaseDao;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * Add new author to dictionary. Author has only name.
 */

public class AddAuthorAction extends Action {
	private UploadInterfaceDao uploadToDatabase;

	@Override
	public ActionForward execute(ActionMapping mapping,
								 ActionForm form,
								 HttpServletRequest request,
								 HttpServletResponse response) {
		AddAuthorForm addAuthorForm = (AddAuthorForm) form;
		AuthorsEntity authorToAdded = new AuthorsEntity();
		authorToAdded.setName(addAuthorForm.getName());
		uploadToDatabase.commitAuthor(authorToAdded);
		AuthorPublishingList.getAuthorList().add(authorToAdded);
		return mapping.findForward("add");
	}

	/**		instead @EJB annotation!		*/
	public AddAuthorAction() {
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
