package pl.jg.action;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import pl.jg.model.Book;
import pl.jg.model.BookDaoImpl;

public class DeleteBookActionBean extends BaseActionBean {
	
	private BookDaoImpl bookDaoImpl;
	
	@SpringBean("bookDaoImpl")
	public void injectBookDaoImpl(BookDaoImpl bookDaoImpl) {
		this.bookDaoImpl = bookDaoImpl;
	}
		
	private static final String VIEW = "/WEB-INF/jsp/deleteBook.jsp";
	
	private ActionBeanContext actionBeanContext;

	private Book bookToDelete;
	
	public BookDaoImpl getBookDaoImpl() {
		return bookDaoImpl;
	}

	public void setBookDaoImpl(BookDaoImpl bookDaoImpl) {
		this.bookDaoImpl = bookDaoImpl;
	}

	public Book getBookToDelete() {
		return bookToDelete;
	}


	public void setBookToDelete(Book bookToDelete) {
		this.bookToDelete = bookToDelete;
	}


	@DefaultHandler
	public Resolution deleteBook() {
	
		this.bookDaoImpl.deleteBook(bookToDelete);
		
		return new ForwardResolution(VIEW);
	}
}
