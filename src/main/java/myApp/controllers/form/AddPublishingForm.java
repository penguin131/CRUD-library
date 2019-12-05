package myApp.controllers.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

public class AddPublishingForm extends org.apache.struts.action.ActionForm {
	private String name;

	@Override
	public ActionErrors validate(ActionMapping mapping,
								 HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
		if (name.length() == 0) {
			errors.add("length", new ActionMessage("zero.params"));
		}
		return errors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
