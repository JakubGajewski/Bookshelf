package pl.jg.model;

import java.util.List;

public interface BookDaoInterface {
	
	List <Book> getAllBooks();
	Book getBookByTitle(String title);
	void saveBook (Book book);
	void deleteBook (Book book);
	
}
