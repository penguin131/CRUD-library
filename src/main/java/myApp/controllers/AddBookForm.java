package myApp.controllers;

import myApp.utils.HibernateUtil;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.hibernate.Session;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.List;

public class AddBookForm extends org.apache.struts.action.ActionForm {
	private String title;
	private String year;
	private String cost;
	private String author;
	private String publishing;
	private List authorList;
	private List publishingList;

	public AddBookForm() {
		final Session session1 = HibernateUtil.getHibernateSession();
		session1.beginTransaction();
		authorList = session1.createQuery("from AuthorsEntity order by name").list();
		publishingList = session1.createQuery("from PublishingEntity order by name").list();
		session1.close();
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
								 HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
		int formYear;
		float formCost;
		try {
			formYear = Integer.parseInt(getYear());
			formCost = Float.parseFloat(getCost());
			if (formYear < 1753 || formYear > Calendar.getInstance().get(Calendar.YEAR)) {
				errors.add("year", new ActionMessage("incorrect.year"));
			}
			if (formCost < 0) {
				errors.add("cost", new ActionMessage("negative.cost"));
			}
		} catch (Exception e) {
			errors.add("numbers", new ActionMessage("parse.error"));
		}
		if (title.length() == 0 || year.length() == 0 || publishing.length() == 0) {
			errors.add("length", new ActionMessage("zero.params"));
			return errors;
		}
		return errors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	public List getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List authorList) {
		this.authorList = authorList;
	}

	public List getPublishingList() {
		return publishingList;
	}

	public void setPublishingList(List publishingList) {
		this.publishingList = publishingList;
	}
}
