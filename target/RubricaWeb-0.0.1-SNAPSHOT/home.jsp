<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="it.rdev.rubrica.model.entities.Contact" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- 	<jsp:useBean id="user" scope="request" class="it.rdev.rubrica.dto.User"> --%>
<%-- 		<jsp:setProperty name="user" property="*"/> --%>
<%-- 	</jsp:useBean> --%>
	
<%-- 	<%=user.getUsername()  + " " + user.getPassword() %> --%>
	<%  
		List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
 	%>
	<table>
	<thead>
		<tr><td>Username</td><td>Password</td></tr>
	</thead>
	<tbody>
	<c:forEach items="${contacts}" var="c">
		<tr>
			<td><c:out value="${c.name}"></c:out></td>
			<td><c:out value="${c.surname}"></c:out></td>
		</tr>
	</c:forEach>
	</tody>
	</table>

<a href="/RubricaWeb/LoginServlet?action=insert">Inserisci Contatto</a>
<a href="/RubricaWeb/LoginServlet?action=delete">Cancella Contatto</a>
<a href="/RubricaWeb/LoginServlet?action=update">Aggiorna contatto</a>
</body>
</html>