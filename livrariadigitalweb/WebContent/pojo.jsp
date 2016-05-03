<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>TESTE</h1>
<jsp:useBean id="livro" class="livrariadigital.modelo.Livro"/>
<jsp:useBean id="dao" class="livrariadigital.dao.LivroDao"></jsp:useBean>
${livro.titulo}
testando...
<br><br>
<c:out value="${dao.lista[0].titulo}"></c:out> 00<br><br>
</body>
</html>