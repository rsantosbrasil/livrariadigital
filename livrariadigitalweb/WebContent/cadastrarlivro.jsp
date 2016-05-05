<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="snc" %>

<html lang="pt-br">
<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>Cadastrar Livros</title>

 <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
 <link href="bootstrap/css/style.css" rel="stylesheet">
 <link href="bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
</head>
<body>
<c:import url="cabecalho.jsp" />
 <div id="main" class="container-fluid">
  
  <h3 class="page-header">Adicionar livro</h3>
  
  <form action="controller">
  <input type="hidden" name="regraDeNegocio" value="CadastraLivro">
  	<div class="row">
  	  <div class="form-group col-md-4">
  	  	<label for="exampleInputEmail1">Titulo</label>
  	  	<input type="text" name="titulo" class="form-control" id="exampleInputEmail1" placeholder="Digite o valor">
  	  </div>
	  <div class="form-group col-md-4">
  	  	<label for="exampleInputEmail1">Autor</label>
  	  	<input type="text" name="autor" class="form-control" id="exampleInputEmail1" placeholder="Digite o valor">
  	  </div>
	  <div class="form-group col-md-4">
  	  	<label for="exampleInputEmail1">Editora</label>
  	  	<input type="text" name="editora" class="form-control" id="exampleInputEmail1" placeholder="Digite o valor">
  	  </div>
	</div>
	
	<div class="row">
  	  <div class="form-group col-md-3">
  	  	<label for="exampleInputEmail1">Email</label>
  	  	<input type="email" name="email" class="form-control" id="exampleInputEmail1" placeholder="Digite o valor">
  	  </div>
	  <div class="form-group col-md-3">
  	  	<label for="exampleInputEmail1">Data Lançamento</label>	
  	  <!-- <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Digite o valor">-->
  	  	<snc:data id="data"/>
  	  </div>
  	 </div>
	<hr />
		
	<div class="row">
	  <div class="col-md-12">
	  	<button type="submit" value="cadastrar" class="btn btn-primary">Salvar</button>
		<a href="index.jsp" class="btn btn-default">Cancelar</a>
	  </div>
	</div>
  </form>
 </div>

<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/bootstrap-datepicker.js"></script>
</body>
</html>