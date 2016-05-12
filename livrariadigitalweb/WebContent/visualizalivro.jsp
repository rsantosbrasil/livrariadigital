<%@page import="livrariadigital.modelo.Livro"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="snc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<%Livro livro = (Livro) request.getAttribute("livro"); %>
<c:import url="cabecalho.jsp" />
<!-- Modal -->
<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="modalLabel">Excluir Item</h4>
      </div>
      <div class="modal-body">
        Deseja realmente excluir este item?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Sim</button>
	<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
      </div>
    </div>
  </div>
</div>

 <div id="main" class="container-fluid">
  <h3 class="page-header">Visualizar Item #1</h3>
  <form action="controller">
  <input type="hidden" name="regraDeNegocio" value="CarregaDados">
  <div class="row">
    <div class="col-md-4">
      <p><strong>Cadastro</strong></p>
  	  <p><%=livro.getId()%></p>
    </div>
    <div class="col-md-4">
      <p><strong>Titulo</strong></p>
  	  <p><%=livro.getTitulo()%></p>
    </div>
	
	<div class="col-md-4">
      <p><strong>Autor</strong></p>
  	  <p><%=livro.getAutor() %></p>
    </div>
	
	<div class="col-md-4">
      <p><strong>Editora</strong></p>
  	  <p><%=livro.getEditora() %></p>
    </div>

    <div class="col-md-4">
      <p><strong>Email</strong></p>
  	  <p><%=livro.getEmail() %></p>
    </div>
	
	<div class="col-md-4">
      <p><strong>Data de Lançamento</strong></p>
  	  <p><%=livro.getDataLancamento()%></p>
    </div>
 </div>
 
 <hr />
 <div id="actions" class="row">
   <div class="col-md-12">
     <a href="index.jsp" class="btn btn-primary">Fechar</a>
	 <a href="controller?regraDeNegocio=CarregaDadosEdit&id=${livro.id}" class="btn btn-default">Editar</a>
	 <a href="controller?regraDeNegocio=ExcluiLivro&id=${livro.id}" class="btn btn-default">Excluir</a>
   </div>
 </div>
 </form>
 </div> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>