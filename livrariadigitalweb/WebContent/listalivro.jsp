<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<link href="css/estilo.css" rel="stylesheet">
		<title>Lista de  livros</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
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

			<c:forEach var="livro" items="${dao.listaLivro}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'd3d3d3' : 'ffffff' }">
				<td>${id.count}</td>
				<td>${livro.titulo}</td>
				<td>${livro.autor}</td>
				<td>${livro.editora}</td>
				<td>
					<c:if test="${not empty livro.email}">
						<a href="mailto:${livro.email}">${livro.email}</a>
					</c:if>
					<c:if test="${empty livro.email}">
						E-mail não informado
					</c:if>
				</td>
				<td>
					<fmt:formatDate value="${livro.dataLancamento.time}" pattern="dd-MMM-yyyy"/>
				</td>
			</tr>
			</c:forEach>
		</table>
		<c:import url="rodape.jsp" />
	</body>
</html>