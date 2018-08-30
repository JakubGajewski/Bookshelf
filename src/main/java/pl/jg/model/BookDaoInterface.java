package pl.jg.model;

import java.util.List;

public interface BookDaoInterface {
	
	List <Book> getAllBooks();
	List <Book> getSpecificBooks(String[] searchCriteria);
	void updateBook(Book book);
	void deleteBook (Book book);
	void addBook (Book book);
	
}
