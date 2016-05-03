<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="livrariadigital.modelo.*, livrariadigital.dao.*, livrariadigital.jdbc.*, java.util.*" %>
<ul>
	<% 
	LivroDao dao = new LivroDao();
	List<Livro> livros = dao.getLista();
	for(int i =0; i<livros.size(); i++){
		Livro livro = livros.get(i);
	
	%>
		<li>
			<%=livro.getTitulo() %>, <%= livro.getAutor() %>
		</li>	
	<%
	}
	%>
</ul>
</body>
</html>