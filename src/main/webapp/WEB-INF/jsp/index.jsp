<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>

<html>
<body>
<body style="text-align: center">

	<h5>
		<stripes:link beanclass="pl.jg.action.BookshelfActionBean">List of all books  </stripes:link>
		<stripes:link beanclass="pl.jg.action.AddBookActionBean">Add a new book</stripes:link>
	</h5>

	<h1>My Bookshelf</h1>
	</br>

	<h2>List of all books:</h2>
	
	<c:forEach items="${actionBean.books}" var="theBook">
    	<h6><c:out value="${theBook}"/></br></h6>  
	</c:forEach>

	
</body>
</body>
</html>
