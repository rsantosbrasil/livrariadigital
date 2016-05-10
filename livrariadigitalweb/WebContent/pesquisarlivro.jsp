<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>CRUD com Bootstrap 3</title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/style.css" rel="stylesheet">
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<jsp:useBean id="dao" class="livrariadigital.dao.LivroDao"></jsp:useBean>
	<div id="main" class="container-fluid" style="margin-top: 50px">

		<div id="top" class="row">
			<div class="col-sm-3">
				<h2>Livros</h2>
			</div>
			<div class="col-sm-6">

				<form action="controller">
					<input type="hidden" name="regraDeNegocio" value="PesquisarLivro">

					<div class="table-responsive col-md-12">
						<table class="table table-striped" cellspacing="0" cellpadding="0">
							<thead>
								<tr>
									<td>Id</td>
									<td>Titulo</td>
									<td>Autor</td>
									<td>Editora</td>
									<td>E-mail</td>
									<td>Data de lançamento</td>
									<th class="actions">Ações</th>
								</tr>
							</thead>

							<c:forEach var="livro" items="${dao.pesquisaPalavra}"
								varStatus="id">
								<tbody>
									<tr>
										<td>${id.count}</td>
										<td>${livro.titulo}</td>
										<td>${livro.autor}</td>
										<td>${livro.editora}</td>
										<td><c:if test="${not empty livro.email}">
												<a href="mailto:${livro.email}">${livro.email}</a>
											</c:if> <c:if test="${empty livro.email}">
						E-mail nÃ£o informado
					</c:if></td>
										<td><fmt:formatDate value="${livro.dataLancamento.time}"
												pattern="dd-MMM-yyyy" /></td>

										<td class="actions"><a class="btn btn-success btn-xs"
											href="visualizalivro.jsp">Visualizar</a> <a
											class="btn btn-warning btn-xs" href="editarLivro.jsp">Editar</a>
											<a class="btn btn-danger btn-xs" href="#" data-toggle="modal"
											data-target="#delete-modal">Excluir</a></td>
									</tr>
								</tbody>
							</c:forEach>
						</table>
					</div>
				</form>
			</div>

		</div>
		<!-- /#list -->

		<div id="bottom" class="row">
			<div class="col-md-12">
				<ul class="pagination">
					<li class="disabled"><a>&lt; Anterior</a></li>
					<li class="disabled"><a>1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li class="next"><a href="#" rel="next"> Próximo &gt;</a></li>
				</ul>
				<!-- /.pagination -->
			</div>
		</div>


	</div>