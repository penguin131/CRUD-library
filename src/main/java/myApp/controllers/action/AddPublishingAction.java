package myApp.controllers.action;

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
		PublishingEntity authorToAdded = new PublishingEntity();
		authorToAdded.setName(addPublishingForm.getName());
		session.save(authorToAdded);
		session.getTransaction().commit();
		session.close();
		return mapping.findForward("add");
	}
}
