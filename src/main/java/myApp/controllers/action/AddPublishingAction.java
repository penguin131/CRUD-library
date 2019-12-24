package myApp.controllers.action;

import myApp.controllers.AuthorPublishingList;
import myApp.controllers.form.AddPublishingForm;
import myApp.model.AuthorsEntity;
import myApp.model.PublishingEntity;
import myApp.utils.DbConfiguration;
import myApp.utils.HibernateUtil;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddPublishingAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping,
								 ActionForm form,
								 HttpServletRequest request,
								 HttpServletResponse response) {
		AddPublishingForm addPublishingForm = (AddPublishingForm) form;

		PublishingEntity publishingToAdded = new PublishingEntity();
		publishingToAdded.setName(addPublishingForm.getName());
		EntityManager em = DbConfiguration.getEm();
		em.getTransaction().begin();
		em.persist(publishingToAdded);
		em.flush();
		em.getTransaction().commit();

		AuthorPublishingList.getPublishingList().add(publishingToAdded);
		return mapping.findForward("add");
	}
}
