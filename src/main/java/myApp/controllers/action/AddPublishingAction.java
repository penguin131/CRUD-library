package myApp.controllers.action;

import myApp.controllers.AuthorPublishingList;
import myApp.controllers.form.AddPublishingForm;
import myApp.model.PublishingEntity;
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

public class AddPublishingAction extends Action {
	private UploadInterfaceDao uploadToDatabase;

	@Override
	public ActionForward execute(ActionMapping mapping,
								 ActionForm form,
								 HttpServletRequest request,
								 HttpServletResponse response) {
		AddPublishingForm addPublishingForm = (AddPublishingForm) form;

		PublishingEntity publishingToAdded = new PublishingEntity();
		publishingToAdded.setName(addPublishingForm.getName());
		uploadToDatabase.commitPublishing(publishingToAdded);

		AuthorPublishingList.getPublishingList().add(publishingToAdded);
		return mapping.findForward("add");
	}

	public AddPublishingAction() {
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
