package pl.jg.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
		List<Book> books = new ArrayList<Book>();

		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				books.add(createBookFromResultSet(resultSet));
			}

			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("Error while trying to add new book");
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
		return books;
	}

	@Override
	public Book getById(int id) {

		if (id == 0) {
			return null;
		}

		String sql = "SELECT * FROM book WHERE id = " + id;
		Connection connection = null;
		ResultSet resultSet = null;
		Book book = new Book();

		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			resultSet.next();
			book.setId(resultSet.getInt("id"));
			book.setTitle(resultSet.getString("title"));
			book.setAuthor(resultSet.getString("author"));
			book.setPublicationYear(resultSet.getInt("publication_year"));
			book.setDescription(resultSet.getString("description"));

			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println(sql);
			System.out.println(id);
			System.out.println("Error while trying to get a book by id");
			throw new RuntimeException(e);

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
		return book;
	}

	@Override
	public void addBook(Book book) {

		String sql = "INSERT INTO book (title, author, publication_year, description) VALUES (?, ?, ?, ?)";
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setInt(3, book.getPublicationYear());
			preparedStatement.setString(4, book.getDescription());
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("Error while trying to add new book");
			throw new RuntimeException(e);

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void deleteBook(int id) {

		String sql = "DELETE FROM book WHERE id = " + id;
		Connection connection = null;

		try {
			System.out.println(sql);
			connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();

		} catch (SQLException e) {
			System.out.println("Error while trying to add new book");
			throw new RuntimeException(e);

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	@Override
	public void updateBook(String author, String title, Integer publicationYear, String description, int id) {
				
		String sql = "UPDATE book SET author = (?), title = (?), publication_year = (?), description = (?) WHERE id = (?)";
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, author);
			preparedStatement.setString(2, title);
			preparedStatement.setInt(3, publicationYear);
			preparedStatement.setString(4, description);
			preparedStatement.setInt(5, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("Error while trying to update");
			throw new RuntimeException(e);

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public List<Book> getSpecificBooks(String[] searchCriteria) {

		SearchSqlGenerator searchSqlGenerator = new SearchSqlGenerator();

		String sql = searchSqlGenerator.search(searchCriteria);

		System.out.println(sql);

		Connection connection = null;
		ResultSet resultSet = null;
		List<Book> books = new ArrayList<Book>();

		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				books.add(createBookFromResultSet(resultSet));
			}

			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("Error while trying to get specific books");
			throw new RuntimeException(e);

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}

		return books;

	}

	@Override
	public Book getNext(int id) {

		Book thisBook = this.getById(id);
		List<Book> books = getAllBooks();
		Book nextBook = null;
		if (books.isEmpty()) {
			return null;
		}
		if (id == books.get(books.size() - 1).getId()) {
			return books.get(0);
		}
		int index = books.indexOf(thisBook);
		nextBook = books.get(index + 1);
		return nextBook;
	}

	@Override
	public Book getPrevious(int id) {

		Book thisBook = this.getById(id);
		List<Book> books = getAllBooks();
		Book previousBook = null;
		if (books.isEmpty()) {
			return null;
		}
		if (id == books.get(0).getId()) {
			return books.get((books.size() - 1));
		}
		int index = books.indexOf(thisBook);
		previousBook = books.get(index - 1);
		return previousBook;
	}

	public Book createBookFromResultSet(ResultSet resultSet) throws SQLException {

		Book book = new Book();
		book.setId(resultSet.getInt("id"));
		book.setTitle(resultSet.getString("title"));
		book.setAuthor(resultSet.getString("author"));
		book.setPublicationYear(resultSet.getInt("publication_year"));
		book.setDescription(resultSet.getString("description"));
		return book;
	}
	
	//TODO: methods for whole connection stuff (one for prepared statement, another for statement)
}
