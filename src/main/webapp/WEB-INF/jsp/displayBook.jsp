<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
	title="Book view">
	<s:layout-component name="body">
	
	
		<a href="https://pl.wikipedia.org/wiki/${actionBean.book.author}">Author: ${actionBean.book.author}</a></br>
		<a href="https://pl.wikipedia.org/wiki/${actionBean.book.title}">Title: ${actionBean.book.title}</a></br>
		<a href="https://pl.wikipedia.org/wiki/${actionBean.book.publicationYear}">Publication year: ${actionBean.book.publicationYear}</a></br>
		Description: ${actionBean.book.description}</br></br>
		
		<s:link beanclass="pl.jg.action.DisplayBookActionBean"
		event="nextBook" >
			<s:param name="bookId" value="${actionBean.book.id}"/>
			Next book</br>
		</s:link>
		
		<s:link beanclass="pl.jg.action.DisplayBookActionBean"
		event="previousBook" >
			<s:param name="bookId" value="${actionBean.book.id}"/>
			Previous book</br>
		</s:link>
		
		<s:link beanclass="pl.jg.action.DisplayBookActionBean"
		event="deleteBook" >
			<s:param name="bookId" value="${actionBean.book.id}"/>
			Delete book
		</s:link>
		</br>
				
<!-- 	<s:link beanclass="pl.jg.action.UpdateBookActionBean">
			<s:param name="bookId" value="${actionBean.book.id}"/>
			Update book
		</s:link>
 -->		
	</s:layout-component>
</s:layout-render>

