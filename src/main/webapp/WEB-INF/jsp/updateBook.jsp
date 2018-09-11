<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
	title="Book view">
	<s:layout-component name="body">
		<%-- <h3>
			<s:form beanclass="pl.jg.action.UpdateBookActionBean">
				<s:param name="bookId" value="${actionBean.bookId}"/>
				<s:param name="columnName" value="author"/>		
				Enter book's author:</br>
				<s:text name="value" value="dupa"/></br>
				<s:submit name="submit" value="submit" />
			</s:form></br>
			<s:form beanclass="pl.jg.action.UpdateBookActionBean">
				<s:param name="bookId" value="${actionBean.bookId}"/>
				<s:param name="columnName" value="title"/>
				Enter book's title:</br>
				<s:text name="value" /></br>
				<s:submit name="submit" value="submit" />
			</s:form></br>
			<s:form beanclass="pl.jg.action.UpdateBookActionBean">
				<s:param name="bookId" value="${actionBean.bookId}"/>
				<s:param name="columnName" value="publication_year"/>		
				Enter book's publication year:</br>
				<s:text name="value" /></br>
				<s:submit name="submit" value="submit" />
			</s:form></br>
			<s:form beanclass="pl.jg.action.UpdateBookActionBean">
				<s:param name="bookId" value="${actionBean.bookId}"/>
				<s:param name="columnName" value="description"/>
				Enter book's description:</br>
				<s:text name="value" /></br>
				<s:submit name="submit" value="submit" />
			</s:form></br>		
		</h3>	 --%>
		<h3>
			<s:form beanclass="pl.jg.action.UpdateBookActionBean">
				<s:param name="bookId" value="${actionBean.book.bookId}"/>
				<s:param name="columnName" value="author"/>		
				Enter book's author:</br>
				<s:text name="value" value="${actionBean.book.author}"/></br>
				<s:param name="bookId" value="${actionBean.bookId}"/>
				<s:param name="columnName" value="title"/>
				Enter book's title:</br>
				<s:text name="value" value="${actionBean.book.title}"/></br>
				<s:param name="bookId" value="${actionBean.bookId}"/>
				<s:param name="columnName" value="publication_year"/>		
				Enter book's publication year:</br>
				<s:text name="value" value="${actionBean.book.publicationYear}"/></br>
				<s:param name="bookId" value="${actionBean.bookId}"/>
				<s:param name="columnName" value="description"/>
				Enter book's description:</br>
				<s:text name="value" value="${actionBean.book.description}"/></br>
				<s:submit name="submit" value="update" />
			</s:form></br>		
		</h3>	
			<%-- <h3>
				Enter book's author: </br>
				<s:text name="author" /></br>
				Enter book's title: </br>
				<s:text name="title" /></br>
				Enter book's publication year: </br>
				<s:text name="publicationYear" /></br>
				Enter book's description: </br>
				<s:text name="description" /></br>
				<s:submit name="submit" value="submit" /></br>
			</h3> --%>
	</s:layout-component>
</s:layout-render>

