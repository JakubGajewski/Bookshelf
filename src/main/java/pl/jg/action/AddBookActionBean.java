package pl.jg.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import pl.jg.model.Book;
import pl.jg.model.BookDaoImpl;

public class AddBookActionBean implements ActionBean {
	
	private BookDaoImpl bookDaoImpl;
	
	private static final String VIEW = "/WEB-INF/jsp/addBook.jsp";
	
	@SpringBean("bookDaoImpl")
	public void injectBookDaoImpl(BookDaoImpl bookDaoImpl) {
		this.bookDaoImpl = bookDaoImpl;
	}
	
	private ActionBeanContext ctx;
	
	private String title = "";
	private String author = "";
	private int publicationYear;
	
	String message;

	public ActionBeanContext getContext() {
		return ctx;
	}

	public void setContext(ActionBeanContext ctx) {
		this.ctx = ctx;
	}
	
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

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
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
			bookDaoImpl.saveBook(book);
			this.setMessage ("The following book was added:\n" + book.toString());
		}
		
		return new ForwardResolution(VIEW);
	}
}
