package pl.jg.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import pl.jg.model.Book;
import pl.jg.model.BookDaoImpl;

public class DisplayBookActionBean extends BaseActionBean {
	
	private BookDaoImpl bookDaoImpl;
	
	@SpringBean("bookDaoImpl")
	public void injectBookDaoImpl(BookDaoImpl bookDaoImpl) {
		this.bookDaoImpl = bookDaoImpl;
	}
		
	private Book book;
	
	private int bookId;
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@DefaultHandler
	public Resolution displayBook() {
		
		if (bookDaoImpl.getAllBooks().isEmpty()) {
			return new ForwardResolution("/WEB-INF/jsp/displayBook.jsp");
		}
		
		if (bookId != 0) {
		this.setBook(bookDaoImpl.getById(bookId));
		} else {
			this.setBook(bookDaoImpl.getAllBooks().get(0));
		}
		return new ForwardResolution("/WEB-INF/jsp/displayBook.jsp");
	}
	
	public Resolution deleteBook() {
		bookDaoImpl.deleteBook(bookId);
		return new RedirectResolution(BookshelfActionBean.class);
	}
	
	public Resolution nextBook() {
		this.setBook(bookDaoImpl.getNext(bookId));
		return new ForwardResolution("/WEB-INF/jsp/displayBook.jsp");
	}
	
	public Resolution previousBook() {
		this.setBook(bookDaoImpl.getPrevious(bookId));
		return new ForwardResolution("/WEB-INF/jsp/displayBook.jsp");
	}
	
	public Resolution updateBook() {
		return new RedirectResolution(UpdateBookActionBean.class).addParameter("bookId", bookId);
	}
}
