<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<%@include file="/WEB-INF/jsp/common/navbar.jsp" %>

<html>
<body>
<body style="text-align: center">

	<h1>My Bookshelf</h1>
	</br>

	<h2>List of all books:</h2>
	
	<c:forEach items="${actionBean.books}" var="theBook">
    	<h6><c:out value="${theBook}"/></br></h6>  
	</c:forEach>

	
</body>
</body>
</html>
