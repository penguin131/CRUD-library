package myApp.controllers.form;

import myApp.controllers.AuthorPublishingList;
import myApp.controllers.BookFormInterface;
import myApp.controllers.BookValidation;
import myApp.model.AuthorsEntity;
import myApp.model.PublishingEntity;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Read and validate book fields. BOOK_ID CHECKED INTO newBook.jsp
 */

public class EditBookForm extends org.apache.struts.action.ActionForm implements BookFormInterface {
	private String title;
	private String year;
	private String cost;
	private String author;
	private String publishing;
	private ArrayList<AuthorsEntity> authorList;
	private ArrayList<PublishingEntity> publishingList;
	private String bookId;

	public EditBookForm() {
		authorList = AuthorPublishingList.getAuthorList();
		publishingList = AuthorPublishingList.getPublishingList();
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
								 HttpServletRequest request)
	{
		return BookValidation.validateBook(this);
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

	public ArrayList<AuthorsEntity> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(ArrayList<AuthorsEntity> authorList) {
		this.authorList = authorList;
	}

	public ArrayList<PublishingEntity> getPublishingList() {
		return publishingList;
	}

	public void setPublishingList(ArrayList<PublishingEntity> publishingList) {
		this.publishingList = publishingList;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
}
