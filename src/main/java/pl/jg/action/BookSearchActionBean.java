package pl.jg.action;

import java.util.List;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import pl.jg.model.Book;
import pl.jg.model.BookDaoImpl;

public class BookSearchActionBean extends BaseActionBean {
	
	private BookDaoImpl bookDaoImpl;
	
	@SpringBean("bookDaoImpl")
	public void injectBookDaoImpl(BookDaoImpl bookDaoImpl) {
		this.bookDaoImpl = bookDaoImpl;
	}
		
	private static final String VIEW = "/WEB-INF/jsp/bookSearch.jsp";
	
	private List <Book> allBooks;
	
	private List <Book> books;
	
	private String requestedAuthor;
	
	private String requestedTitle;
	
	private Integer requestedPublicationYear;
	
	
	public BookDaoImpl getBookDaoImpl() {
		return bookDaoImpl;
	}

	public void setBookDaoImpl(BookDaoImpl bookDaoImpl) {
		this.bookDaoImpl = bookDaoImpl;
	}

	public List<Book> getAllBooks() {
		return allBooks;
	}

	public void setAllBooks(List<Book> allBooks) {
		this.allBooks = allBooks;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getRequestedAuthor() {
		return requestedAuthor;
	}

	public void setRequestedAuthor(String requestedAuthor) {
		this.requestedAuthor = requestedAuthor;
	}

	public String getRequestedTitle() {
		return requestedTitle;
	}

	public void setRequestedTitle(String requestedTitle) {
		this.requestedTitle = requestedTitle;
	}

	public Integer getRequestedPublicationYear() {
		return requestedPublicationYear;
	}

	public void setRequestedPublicationYear(Integer requestedPublicationYear) {
		this.requestedPublicationYear = requestedPublicationYear;
	}

	@DefaultHandler
	public Resolution books() {
				
		String[] searchCriteria = new String[3];
		
		searchCriteria [0] = requestedAuthor;
		searchCriteria [1] = requestedTitle;
		
		if (requestedPublicationYear != null) {
			searchCriteria [2] = String.valueOf(requestedPublicationYear);
		}
			
		if (searchCriteria[0] != null || searchCriteria[1] != null || searchCriteria[2] != null) {
			books = bookDaoImpl.getSpecificBooks(searchCriteria);
		}
			
		return new ForwardResolution(VIEW);
	}
}
