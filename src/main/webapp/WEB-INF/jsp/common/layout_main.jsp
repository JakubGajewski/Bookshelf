<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<s:layout-definition>
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd" >
	<html>
		<head>
			<title>${title}</title>
			<link rel="stylesheet" type="text/css" href="/bookshelf/css/style.css" >
		</head>
		<body>
			<h5>
				<s:link beanclass="pl.jg.action.BookshelfActionBean">List of books</s:link>
				<s:link beanclass="pl.jg.action.AddBookActionBean">Add a new book</s:link>
				<s:link beanclass="pl.jg.action.BookSearchActionBean">Book search</s:link>
			</h5>
			<div id="header">
				<span class="title">
					<h1>${title}</h1>
				</span>
			</div>
			<div id="body">
				<s:layout-component name="body"/>
			</div>
		</body>
	</html>
</s:layout-definition>