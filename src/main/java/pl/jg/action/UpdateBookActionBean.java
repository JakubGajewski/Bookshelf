package pl.jg.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import pl.jg.model.Book;
import pl.jg.model.BookDaoImpl;
//TODO
public class UpdateBookActionBean extends BaseActionBean {
	
	private BookDaoImpl bookDaoImpl;
	
	@SpringBean("bookDaoImpl")
	public void injectBookDaoImpl(BookDaoImpl bookDaoImpl) {
		this.bookDaoImpl = bookDaoImpl;
	}
		
	private Book book;
	
	private int bookId;
	
	private String author;
	
	private String title;
	
	private Integer publicationYear;
	
	private String description; 
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

//	@DefaultHandler
//	public Resolution updateBook() {
//		
//		System.out.println(bookId);
//		this.setBook(bookDaoImpl.getById(bookId)); //is it necessary to query db every time?
//		System.out.println(this.book.toString());
//		
//		if (columnName != null && value != null) {
//			bookDaoImpl.updateBook(bookId, columnName, value);
//			return new RedirectResolution(DisplayBookActionBean.class).addParameter("bookId", bookId);
//		}
//		return new ForwardResolution("/WEB-INF/jsp/updateBook.jsp");
//	}
}
