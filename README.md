# Bookshelf
Web application to manage books on your bookshelf.

Books are stored in MySQL Database, information about them are stored in three columns: author, title and publication_year. 

User has access to three modules: 
- list of books - to get all of the stored data;
- add a new book;
- book search - search by any (or all) of the three parameters.

Technologies and tools: Java, Stripes Framework, Spring Framework, JSP, JSTL, JDBC, MySQL Database, Maven, IDE Eclipse
  
Design patterns: Data Access Object, Model View Controller, Preaction Pattern
   
About Stripes: 
Stripes is a presentation framework for building web applications using the latest Java technologies. The main driver behind Stripes is that web application development in Java is just too much work! It seems like every existing framework requires gobs of configuration. Struts is pretty feature-light and has some serious architectural issues (see Stripes vs. Struts for details). Others, like WebWork 2 and Spring-MVC are much better, but still require a lot of configuration, and seem to require you to learn a whole new language just to get started. (source: https://stripesframework.atlassian.net/wiki/spaces/STRIPES/overview).