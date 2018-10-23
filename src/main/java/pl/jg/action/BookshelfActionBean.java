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
	
	private String xml;
	
	public void setXml (String xml) {
		this.xml = xml;
	}
	
	public String getXml () {
		return this.xml;
	}
	
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
	
	public Resolution generateXML() {
		//TODO: encoding!
		XMLBookDataCreator xmlBookDataCreator = new XMLBookDataCreator();
		String unescapedXml = xmlBookDataCreator.createXML(bookDaoImpl.getAllBooks());
		String escapedXml = unescapedXml.replaceAll("<", "&lt").replaceAll(">", "&gt");
		this.setXml(escapedXml);
		return new ForwardResolution("/WEB-INF/jsp/xmlOutput.jsp");
	}	
}
