package myApp.controllers.form;

import myApp.controllers.AuthorPublishingList;
import myApp.controllers.BookFormInterface;
import myApp.controllers.BookValidation;
import myApp.model.AuthorsEntity;
import myApp.model.PublishingEntity;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * New books fields and validate his with BookValidation.validateBook
 */

public class AddBookForm extends org.apache.struts.action.ActionForm implements BookFormInterface {
	private String title;
	private String year;
	private String cost;
	private String author;
	private String publishing;
	private ArrayList<AuthorsEntity> authorList;
	private ArrayList<PublishingEntity> publishingList;

	public AddBookForm() {
		authorList = AuthorPublishingList.getAuthorList();
		publishingList = AuthorPublishingList.getPublishingList();
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
								 HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return BookValidation.validateBook(this, true);
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
}
