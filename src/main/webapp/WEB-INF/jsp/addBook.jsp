<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>

<html>
<body style="text-align: center">
	<h5>
		<stripes:link beanclass="pl.jg.action.BookshelfActionBean">List of all books  </stripes:link>
		<stripes:link beanclass="pl.jg.action.AddBookActionBean">Add a new book</stripes:link>
	</h5>

	<h1>My Bookshelf</h1>
	</br>
	<stripes:form beanclass="pl.jg.action.AddBookActionBean">
		<h3>
			Enter book's title:
			</br>
			<stripes:text name="title" />
			</br>
			Enter book's author:
			</br>
			<stripes:text name="author" />
			</br>
			Enter book's publication year:
			</br>
			<stripes:text name="publicationYear" />
			<stripes:submit name="submit" value="submit"/>
		</h3>
	</stripes:form>
	<h3>${actionBean["message"]}</h3>
</body>
</html>
