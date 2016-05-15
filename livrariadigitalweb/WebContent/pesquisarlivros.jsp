<%@page import="livrariadigital.modelo.Livro"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="snc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pesquisar Livros</title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/style.css" rel="stylesheet">
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<!-- Modal -->

<div id="main" class="container-fluid" style="margin-top: 50px">

		<div id="top" class="row">
			<div class="col-sm-3">
				<h2>Livros</h2>
			</div>
	</div>


		
	<div id="list" class="row">
			<div class="table-responsive col-md-12">
				<table class="table table-striped" cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<td> ID </td>
							<td>Titulo</td>
							<td>Autor</td>
							<td>Editora</td>
							<td>E-mail</td>
							<td>Data de lan�amento</td>
							<th class="actions">A��es</th>
						</tr>
					</thead>

					<c:forEach var="livro" items="${livros}" >
						<tbody>
							<tr>
								<td>${livro.id}</td>
								<td>${livro.titulo}</td>
								<td>${livro.autor}</td>
								<td>${livro.editora}</td>
								<td><c:if test="${not empty livro.email}">
										<a href="mailto:${livro.email}">${livro.email}</a>
									</c:if> <c:if test="${empty livro.email}">
						E-mail não informado
					</c:if></td>
								<td><fmt:formatDate value="${livro.dataLancamento.time}"
										pattern="dd-MMM-yyyy" /></td>

								<td class="actions">
								    <a class="btn btn-success btn-xs" href="controller?regraDeNegocio=CarregaDados&id=${livro.id}">Visualizar</a> 
									<a class="btn btn-warning btn-xs" href="controller?regraDeNegocio=CarregaDadosEdit&id=${livro.id}">Editar</a>
									<a class="btn btn-danger btn-xs" href="controller?regraDeNegocio=ExcluiLivro&id=${livro.id}">Excluir</a></td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
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
					<li class="next"><a href="#" rel="next"> Pr�ximo &gt;</a></li>
				</ul>
				<!-- /.pagination -->
			</div>
		</div>
		<!-- /#bottom -->
	</div>
	<!-- /#main -->

	<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
		aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Excluir Livro</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este livro?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary">Sim</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
				</div>
			</div>
		</div>
	</div>

	<script src="bootstrap/js/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>