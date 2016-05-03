<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="livrariadigital.dao.*,livrariadigital.jdbc.*,livrariadigital.modelo.*"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class="livrariadigital.dao.LivroDao"></jsp:useBean>
${dao.lista}<br><br>
<c:out value="${dao.lista[0].titulo}"></c:out> 00<br><br>
<c:forEach var="livro" items="${dao.lista}">
<li>
titulo: ${livro.titulo} 01<br>
<c:out value="${dao.lista[0].titulo}"></c:out> 02<br>
<c:out value="${livro.titulo}"></c:out> 03<br><br>
</li>
</c:forEach>
<br><br>

<c:out value="${dao.lista[0].titulo}"></c:out> 1<br>
<c:out value="${dao.lista[2].titulo}"></c:out> 2<br>
<c:out value="${dao.lista[1].titulo}"></c:out> 3<br>
<c:out value="${dao.lista[3].titulo}"></c:out> 4<br>
<c:out value="${dao.lista[4].titulo}" default="NÃO ENCONTRADO"></c:out> 5<br>
<c:out value="${livro.titulo}"></c:out><br> 6
</body>
</html>