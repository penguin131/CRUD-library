package myApp.controllers;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import java.util.Calendar;

/**
 * Book form validation for AddBookAction and EditBookAction through BookFormInterface. BookID CHECKED INTO newBook.jsp!
 */

public class BookValidation {
	public static ActionErrors validateBook(BookFormInterface form) {
		ActionErrors errors = new ActionErrors();
		int formYear;
		float formCost;
		try {
			formYear = Integer.parseInt(form.getYear());
			formCost = Float.parseFloat(form.getCost());
			if (formYear < 1753 || formYear > Calendar.getInstance().get(Calendar.YEAR)) {
				errors.add("year", new ActionMessage("incorrect.year"));
			}
			if (formCost < 0) {
				errors.add("cost", new ActionMessage("negative.cost"));
			}
		} catch (Exception e) {
			errors.add("numbers", new ActionMessage("parse.error"));
		}
		if (form.getTitle().length() == 0 || form.getYear().length() == 0 || form.getCost().length() == 0 ||
				form.getAuthor() == null || form.getPublishing() == null) {
			errors.add("length", new ActionMessage("zero.params"));
			return errors;
		}
		return errors;
	}
}
