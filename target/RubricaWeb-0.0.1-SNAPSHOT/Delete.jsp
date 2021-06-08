<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.util.List" %>
<%@ page import="it.rdev.rubrica.model.entities.Contact" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%  
		List<Contact> contacts = (List<Contact>) request.getAttribute("contatti");
    request.setAttribute("valore", 3);
 	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/RubricaWeb/LoginServlet" method="post">

<table>
	<thead>
		<tr><td>Username</td><td>Password</td></tr>
	</thead>
	<tbody>
	<%if(contacts!= null){
		
	}
	%>
	<c:forEach items="${contacts}" var="c">
		<tr>
			<td><c:out value="${c.name}"></c:out></td>
			<td><c:out value="${c.surname}"></c:out></td>
		</tr>
	</c:forEach>
	</tody>

	</table>
	<p>
			Inserisci l'id: <input type="text" name="delid">
    </p>
	<button type="submit">LogIn</button>

</form>
</body>
</html>