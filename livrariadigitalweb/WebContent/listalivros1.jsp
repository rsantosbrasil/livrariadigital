<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lista livros</title>
	</head>
	<body>
		<jsp:useBean id="dao" class="livrariadigital.dao.LivroDao"></jsp:useBean>
		<table border="1">
			<tr bgcolor="6c7b8b" align="center">
				<td>Id</td>
				<td>Titulo</td>
				<td>Autor</td>
				<td>Editora</td>
				<td>E-mail</td>
				<td>Data de lançamento</td>
			</tr>

			<c:forEach var="livro" items="${dao.lista}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'd3d3d3' : 'ffffff' }">
				<td>${id.count}</td>
				<td>${livro.titulo}</td>
				<td>${livro.autor}</td>
				<td>${livro.editora}</td>
				<td>${livro.email}</td>
				<td>${livro.dataLancamento.time}</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>