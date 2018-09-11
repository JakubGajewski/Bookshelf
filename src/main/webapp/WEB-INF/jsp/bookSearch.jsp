<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
	title="Book search">
	<s:layout-component name="body">
		<h3>
			<s:form beanclass="pl.jg.action.BookSearchActionBean">		
				Enter book's author:</br>
				<s:text name="requestedAuthor"/></br>
				Enter book's title:</br>
				<s:text name="requestedTitle" /></br>
				Enter book's publication year:</br>
				<s:text name="requestedPublicationYear" /></br>
				<s:submit name="submit" value="submit" />
			</s:form></br>
		</h3>
		<h2>List of books searched by criteria:</h2>
	
		<%@include file="/WEB-INF/jsp/common/book_list.jsp"%>
	
	</s:layout-component>
</s:layout-render>