package myApp.controllers.action;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import javax.servlet.http.HttpServletRequest;

/**
 * Read sort param.
 */

public class MainPageForm extends org.apache.struts.action.ActionForm {
	private String sortParam;

	@Override
	public ActionErrors validate(ActionMapping mapping,
								 HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
		if (sortParam != null && !sortParam.equals("ASC") && !sortParam.equals("DESC")) {
			errors.add("sortParams", new ActionMessage("unexpected sortParam"));
		}
		return errors;
	}

	public String getSortParam() {
		return sortParam != null ? sortParam : "ASC";
	}

	public void setSortParam(String sortParam) {
		this.sortParam = sortParam;
	}
}
