package pl.jg.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class BookDaoImpl implements BookDaoInterface {
	
	private DataSource dataSource;
		
	public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
	}		
		
	@Override
	public List<Book> getAllBooks() {
		
		String sql = "SELECT * FROM book";
		Connection connection = null;
		ResultSet resultSet = null;
		List <Book> books = new ArrayList<Book>();
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setPublicationYear(resultSet.getInt("publication_year"));
				books.add(book);
			}
			
			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("Error while trying to add new book");
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		return books;
	}

	@Override
	public void addBook(Book book) {
		
		String sql = "INSERT INTO book (title, author, publication_year) VALUES (?, ?, ?)";
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setInt(3, book.getPublicationYear());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException e) {
			System.out.println("Error while trying to add new book");
			throw new RuntimeException(e);
			
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public void deleteBook(Book book) {
		
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> getSpecificBooks(String[] searchCriteria) {
		
		SearchSqlGenerator searchSqlGenerator = new SearchSqlGenerator();
		
		String sql = searchSqlGenerator.search(searchCriteria);	
		
		System.out.println(sql);
		
		Connection connection = null;
		ResultSet resultSet = null;
		List <Book> books = new ArrayList<Book>();
		
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setPublicationYear(resultSet.getInt("publication_year"));
				books.add(book);
			}
			
			preparedStatement.close();
			
		} catch (SQLException e) {
			System.out.println("Error while trying to get specific books");
			throw new RuntimeException(e);
			
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		return books;
		

		
	}
	
	
	
	
}
	
