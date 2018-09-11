package pl.jg.model;

import java.util.List;

public interface BookDaoInterface {
	
	List <Book> getAllBooks();
	List <Book> getSpecificBooks(String[] searchCriteria);
	Book getById(int id);
	Book getNext(int id);
	Book getPrevious(int id);
	void updateBook(String author, String title, Integer publicationYear, String description, int id);
	void deleteBook (int id);
	void addBook (Book book);
	
}
