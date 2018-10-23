package pl.jg.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import pl.jg.model.Book;
import pl.jg.model.BookDaoImpl;

public class AddBookActionBean extends BaseActionBean {
	
	private BookDaoImpl bookDaoImpl;
	
	private static final String VIEW = "/WEB-INF/jsp/addBook.jsp";
	
	@SpringBean("bookDaoImpl")
	public void injectBookDaoImpl(BookDaoImpl bookDaoImpl) {
		this.bookDaoImpl = bookDaoImpl;
	}
	
	private String title = "";
	private String author = "";
	private Integer publicationYear;
	private String description = "";
	
	String message;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@DefaultHandler
	public Resolution saveBook() {
		
		this.setMessage("");
					
		if (title.length()>0) {
			Book book = new Book();
			book.setTitle(title);
			book.setAuthor(author);
			book.setPublicationYear(publicationYear);
			book.setDescription(description);
			bookDaoImpl.addBook(book);
			this.setMessage ("The following book was added:\n" + book.toString());
		}
		
		return new ForwardResolution(VIEW);
	}
}
