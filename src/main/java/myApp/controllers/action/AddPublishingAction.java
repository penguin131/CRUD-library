package myApp.controllers.action;

import myApp.controllers.AuthorPublishingList;
import myApp.controllers.form.AddPublishingForm;
import myApp.model.PublishingEntity;
import myApp.utils.HibernateUtil;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddPublishingAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping,
								 ActionForm form,
								 HttpServletRequest request,
								 HttpServletResponse response) {
		AddPublishingForm addPublishingForm = (AddPublishingForm) form;
		final Session session = HibernateUtil.getHibernateSession();
		session.beginTransaction();
		PublishingEntity publishingToAdded = new PublishingEntity();
		publishingToAdded.setName(addPublishingForm.getName());
		session.save(publishingToAdded);
		session.getTransaction().commit();
		session.close();
		AuthorPublishingList.getPublishingList().add(publishingToAdded);
		return mapping.findForward("add");
	}
}
