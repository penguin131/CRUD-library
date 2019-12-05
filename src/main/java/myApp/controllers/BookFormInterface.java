package myApp.controllers;

import java.util.List;

/**
 * Book form interface for validate
 */
public interface BookFormInterface {
	String getTitle();
	String getYear();
	String getCost();
	String getAuthor();
	String getPublishing();
	List getAuthorList();
	List getPublishingList();
}
