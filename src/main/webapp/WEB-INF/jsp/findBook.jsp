<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<%@include file="/WEB-INF/jsp/common/navbar.jsp" %>

<html>
<body style="text-align: center">
	<h1>Find book</h1>
	</br>
	<s:form beanclass="pl.jg.action.AddBookActionBean">
		<h3>
			Enter book's title:
			</br>
			<s:text name="title" />
			</br>
			Enter book's author:
			</br>
			<s:text name="author" />
			</br>
			Enter book's publication year:
			</br>
			<s:text name="publicationYear" />
			<s:submit name="submit" value="submit"/>
		</h3>
	</s:form>
	<h3>${actionBean["message"]}</h3>
</body>
</html>
