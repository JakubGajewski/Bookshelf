<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<uri="http://s.sourceforge.net/s.tld"%> <%@include
	file="/WEB-INF/jsp/common/taglibs.jsp"%>


	<table class="zupa center">
		<tr>
			<th>Author</th>
			<th>Title</th>
			<th>Publication year</th>
		</tr>
		<c:forEach var="book" items="${actionBean.books}">
				<tr>
					<td>${book.author}</td>
					<td>${book.title}</td>
					<td>${book.publicationYear}</td>
					
					<td>
						<s:link beanclass="pl.jg.action.DisplayBookActionBean" event="displayBook" >
							<s:param name="bookId" value="${book.id}"/>
							x
						</s:link>							
					</td>
				</tr>
		</c:forEach>
	</table>
