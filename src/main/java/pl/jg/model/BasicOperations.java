package pl.jg.model;

import java.sql.*;

public class BasicOperations {

	public static void main(String[] args) {
	
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
	

		String dbUrl = "jdbc:mysql://localhost:3306/bookshelf?useSSL=false&&allowPublicKeyRetrieval=true";
		String userName = "test";
		String password = "test";

		try {
			connection = DriverManager.getConnection(dbUrl, userName, password);
			statement = connection.createStatement();
			
			statement.executeUpdate("insert into book (title, author, publication_year) VALUES (\"Intro to Java Programming\", \"Liang Y\", 2010)");
					
			resultSet = statement.executeQuery("SELECT * FROM bookshelf.book");
									
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString("title"));
				System.out.println(resultSet.getString("author"));
				System.out.println(resultSet.getString("publication_year"));
			}
			
		} catch (SQLException e) {
			System.out.println("An error occured!");
			e.printStackTrace();
		}
	}
}
