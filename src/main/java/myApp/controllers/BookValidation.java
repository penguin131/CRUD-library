package myApp.controllers;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import java.util.Calendar;

/**
 * Book form validation for AddBookAction and EditBookAction through BookFormInterface. BookID CHECKED INTO editBook.jsp!
 * Edit book form - checkZero = false.
 */

public class BookValidation {
	public static ActionErrors validateBook(BookFormInterface form, boolean checkZero) {
		ActionErrors errors = new ActionErrors();
		int formYear;
		float formCost;
		try {
			if (form.getYear().length() > 0 || checkZero) {
				formYear = Integer.parseInt(form.getYear());
				if (formYear < 1753 || formYear > Calendar.getInstance().get(Calendar.YEAR)) {
					errors.add("year", new ActionMessage("incorrect.year"));
				}
			}
			if (form.getCost().length() > 0 || checkZero) {
				formCost = Float.parseFloat(form.getCost());
				if (formCost < 0) {
					errors.add("cost", new ActionMessage("negative.cost"));
				}
			}
		} catch (Exception e) {
			errors.add("numbers", new ActionMessage("parse.error"));
		}
		if (checkZero && (form.getTitle().length() == 0 || form.getYear().length() == 0 || form.getCost().length() == 0 ||
				form.getAuthor() == null || form.getPublishing() == null)) {
			errors.add("length", new ActionMessage("zero.params"));
			return errors;
		}
		return errors;
	}
}
