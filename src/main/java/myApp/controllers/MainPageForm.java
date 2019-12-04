package myApp.controllers;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

public class MainPageForm extends org.apache.struts.action.ActionForm {
	private String sortParam;
	private String bookName;

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

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
}
