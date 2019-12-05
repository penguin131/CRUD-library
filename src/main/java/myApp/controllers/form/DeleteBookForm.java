package myApp.controllers.form;

/**
 * Read book id from form
 */

public class DeleteBookForm extends org.apache.struts.action.ActionForm {
	private String bookId;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
}
