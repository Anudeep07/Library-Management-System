<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%	
	response.sendRedirect("../dashboard.jsp");		
%>

<c:if test="${issuestatus == 'book' }">
		<c:import url="staff/issue/Book.jsp"></c:import>
</c:if>

<c:if test="${issuestatus == 'student' }">
		<c:import url="staff/issue/Student.jsp"></c:import>
</c:if>

<c:if test="${issuestatus == 'complete' }">
		<c:import url="staff/issue/Complete.jsp"></c:import>
</c:if>