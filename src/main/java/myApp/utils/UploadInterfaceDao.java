package myApp.utils;

import myApp.model.AuthorsEntity;
import myApp.model.BooksEntity;
import myApp.model.PublishingEntity;
import javax.ejb.Local;

@Local
public interface UploadInterfaceDao {
	public void commitAuthor(AuthorsEntity author);
	public void commitPublishing(PublishingEntity publishing);
	public void commitBook(BooksEntity book);
}
