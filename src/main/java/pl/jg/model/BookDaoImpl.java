package pl.jg.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDaoInterface {
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	String dbUrl = "jdbc:mysql://localhost:3306/bookshelf?useSSL=false&&allowPublicKeyRetrieval=true";
	String userName = "test";
	String password = "test";
		
	public BookDaoImpl() {
		try	{
			connection = DriverManager.getConnection(dbUrl, userName, password);
			statement = connection.createStatement();
			} catch(SQLException e)
			{
				e.printStackTrace();
			}
		}	
		
	@Override
	public List<Book> getAllBooks() {
		
		List <Book> books = new ArrayList<Book>();	
						
		try {
			resultSet = statement.executeQuery("SELECT * FROM bookshelf.book");

			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setPublicationYear(resultSet.getInt("publication_year"));
				books.add(book);
			}

		} catch (SQLException e) {
			System.out.println("There is a problem with query execution!");
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Book getBookByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveBook(Book book) {
		
		String title = book.getTitle();
		String author = book.getAuthor();
		int publicationYear = book.getPublicationYear();
				
		try {
			System.out.println("INSERT INTO book (title, author, publication_year) VALUES (\"" + title + "\", \"" + author + "\", " + publicationYear + ");" );
			statement.executeUpdate("INSERT INTO book (title, author, publication_year) VALUES (\"" + title + "\", \"" + author + "\", " + publicationYear + ");" );
	
		} catch (SQLException e) {
			System.out.println("Error while trying to add new book");			
			e.printStackTrace();
		}
		}

	@Override
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		
	}
}
	
//	private List <Book> books = new ArrayList<Book>();
//	
//	public Book getBookByTitle(String title) {
//		for (Book book : books) {
//			if (book.getTitle().equals(title)) {
//				return book;
//			}
//		}
//		return null;
//	}
//	
//	public void saveBook (Book book) {
//		this.books.add(book);
//	}
//	
//	public void deleteBook (Book book) {
//		this.books.remove(book);
//	}
//	
//	public List <Book> getAllBooks() {
//		return books;
//	}
//
//	public BookDaoImpl() {
//				
//		Book OgniemiMieczem = new Book (1, "Henryk Sienkiewicz", "Ogniem i Mieczem", 1927);
//		
//		Book Misie = new Book (2, "Henryk Miskiewicz", "Niedzwiedzie w Karpatach", 1987);
//		
//		Book Tadzio = new Book (3, "Adam Mickiewicz", "Pan Tadeusz", 1237);
//		
//		this.saveBook(OgniemiMieczem);
//		
//		this.saveBook(Misie);
//		
//		this.saveBook(Tadzio);
//		}
//	}

