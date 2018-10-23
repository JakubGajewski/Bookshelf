package pl.jg.action;

import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import pl.jg.model.Book;
import pl.jg.model.BookDaoImpl;
import pl.jg.model.XMLBookDataCreator;

public class BookshelfActionBean extends BaseActionBean {
	
	private BookDaoImpl bookDaoImpl;
	
	@SpringBean("bookDaoImpl")
	public void injectBookDaoImpl(BookDaoImpl bookDaoImpl) {
		this.bookDaoImpl = bookDaoImpl;
	}
		
	private List <Book> books;
	
	public List <Book> getBooks() {
		return books;
	}

	public void setBooks(List <Book> books) {
		this.books = books;
	}

	@DefaultHandler
	public Resolution books() {
		this.setBooks(this.bookDaoImpl.getAllBooks());
		return new ForwardResolution("/WEB-INF/jsp/index.jsp");
	}
	
	//TODO: save the output to a file instead of logging to console!
	public Resolution generateXML() {
		XMLBookDataCreator xmlBookDataCreator = new XMLBookDataCreator();
		xmlBookDataCreator.createXML(bookDaoImpl.getAllBooks());
		return new ForwardResolution("/WEB-INF/jsp/index.jsp");
	}	
}
