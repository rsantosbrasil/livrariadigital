<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro livros</title>
	</head>
	<body>
		<c:import url="cabecalho2.jsp" />
		<form action="cadastralivro">
			<h1>Insira os dados do livro a ser cadastrado</h1><br>
			Título:<input type="text" name="titulo" /><br>
			Autor:<input type="text" name="autor" /><br>
			Editora:<input type="text" name="editora" /><br>
			E-mail:<input type="text" name="email" /><br>
			Data de Lançamento:<input type="text" name="data" /><br>
	
			<input type="submit" value="cadastrar">
		</form>
		<c:import url="rodape.jsp" />
	</body>
</html>