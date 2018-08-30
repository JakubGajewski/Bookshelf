<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<%@include file="/WEB-INF/jsp/common/navbar.jsp" %>
	

<html>
<body style="text-align: center">
	<h1>What would you like to find?</h1>
	
	</br>
		<h3>
			<s:form beanclass="pl.jg.action.BookSearchActionBean">		
			Enter book's author:
			<s:text name="requestedAuthor" />
			</br>
			Enter book's title:
			<s:text name="requestedTitle" />
			</br>
			Enter book's year:
			<s:text name="requestedPublicationYear" />
			<s:submit name="submit" value="submit"/>
			</s:form>
			</br>
		</h3>
	<h2>List of books searched by criteria:</h2>
	
	<c:forEach items="${actionBean.searchedBooks}" var="theBook">
    	<h6><c:out value="${theBook}"/></br></h6>  
	</c:forEach>
</body>
</html>
