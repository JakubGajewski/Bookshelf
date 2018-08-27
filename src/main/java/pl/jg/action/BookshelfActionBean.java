package pl.jg.action;

import java.util.List;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import pl.jg.model.Book;
import pl.jg.model.BookDaoImpl;

public class BookshelfActionBean implements ActionBean {
	
	private BookDaoImpl bookDaoImpl;
	
	@SpringBean("bookDaoImpl")
	public void injectBookDaoImpl(BookDaoImpl bookDaoImpl) {
		this.bookDaoImpl = bookDaoImpl;
	}
		
	private static final String VIEW = "/WEB-INF/jsp/index.jsp";
	
	private ActionBeanContext ctx;
	
	private List <Book> books;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
			
	public List <Book> getBooks() {
		return books;
	}

	public void setBooks(List <Book> books) {
		this.books = books;
	}

	public ActionBeanContext getContext() {
		return ctx;
	}

	public void setContext(ActionBeanContext ctx) {
		this.ctx = ctx;
	}

	@DefaultHandler
	public Resolution books() {
		this.setBooks(this.bookDaoImpl.getAllBooks());
		this.setMessage(message);
		return new ForwardResolution(VIEW);
	}
}
