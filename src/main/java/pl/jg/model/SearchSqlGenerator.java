package pl.jg.model;

public class SearchSqlGenerator {
	
	String sql = "SELECT * FROM book ";
	
	public String search(String[] searchCriteria) {
		
		int criteriaCount = 0;
		
		for (String s : searchCriteria) {
			if (s != null) {
				criteriaCount++;
			}
		}
		
		if (criteriaCount == 1) {
			
			if (searchCriteria[0] != null) {
				return sql += "WHERE author = \"" + searchCriteria[0] + "\"";
			}
			if (searchCriteria[1] != null) {
				return sql += "WHERE title = \"" + searchCriteria[1] + "\"";
			}
			if (searchCriteria[2] != null) {
				return sql += "WHERE publication_year = \"" + searchCriteria[2] + "\"";
			}
		}	
		
		if (criteriaCount == 2) {
			
			if (searchCriteria[0] == null) {
				return sql += "WHERE title = \"" + searchCriteria[1] + "\" AND publication_year = \"" + searchCriteria[2] + "\"";
			}
			if (searchCriteria[1] == null) {
				return sql += "WHERE author = \"" + searchCriteria[0] + "\" AND publication_year = \"" + searchCriteria[2] + "\"";
			}
			if (searchCriteria[2] == null) {
				return sql += "WHERE author = \"" + searchCriteria[0] + "\" AND title = \"" + searchCriteria[1] + "\"";
			}
		}
		
		if (criteriaCount == 3) {
			return sql + "WHERE author = \"" + searchCriteria[0] + "\" AND title = \"" + searchCriteria[1] + "\" AND publication_year = \"" + searchCriteria[2] + "\"";
		}
				
		return sql;
	}
}
