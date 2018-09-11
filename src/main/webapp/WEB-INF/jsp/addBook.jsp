<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Add a new book">
	<s:layout-component name="body">
		<s:form beanclass="pl.jg.action.AddBookActionBean">
			<h3>
				Enter book's author: </br>
				<s:text name="author" /></br>
				Enter book's title: </br>
				<s:text name="title" /></br>
				Enter book's publication year: </br>
				<s:text name="publicationYear" /></br>
				Enter book's description: </br>
				<s:text name="description" /></br>
				<s:submit name="submit" value="submit" /></br>
			</h3>
		</s:form>
		<h3>${actionBean["message"]}</h3>
	</s:layout-component>
</s:layout-render>