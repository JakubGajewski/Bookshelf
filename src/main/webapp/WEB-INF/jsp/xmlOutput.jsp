<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
	title="XML view">
	<s:layout-component name="body">
		${actionBean.xml}</br></br>
		<s:link beanclass="pl.jg.action.BookshelfActionBean">Get back to the main page</s:link>	
	</s:layout-component>	
</s:layout-render>

