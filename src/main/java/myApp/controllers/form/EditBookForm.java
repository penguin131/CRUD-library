package myApp.controllers.form;

import myApp.controllers.BookFormInterface;
import myApp.model.BookValidation;
import myApp.model.PullDatabase;
import myApp.utils.HibernateUtil;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.hibernate.Session;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Read and validate book fields, check book id.
 */

public class EditBookForm extends org.apache.struts.action.ActionForm implements BookFormInterface {
	private String title;
	private String year;
	private String cost;
	private String author;
	private String publishing;
	private List authorList;
	private List publishingList;
	private String bookId;

	public EditBookForm() {
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
		ActionErrors errors = BookValidation.validateBook(this);
		if (PullDatabase.getBookForId(Integer.parseInt(bookId)) == null) {
			errors.add("wtf", new ActionMessage("wtf"));
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

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
}
