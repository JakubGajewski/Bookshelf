<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
	title="List of books">
	<s:layout-component name="body">
		<%@include file="/WEB-INF/jsp/common/book_list.jsp"%>
		<s:link beanclass="pl.jg.action.BookshelfActionBean"
			event="generateXML" >Print a book list to the console :-)</s:link>	
	</s:layout-component>	
</s:layout-render>

