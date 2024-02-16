<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	
	<title>Curso JSP</title>
	
	<style type="text/css">
	
		
		h5{
			
			position: absolute;
			top: 30%;
			left: 33%;
			
		}
		
		form{
			
			position: absolute;
			top: 40%;
			left: 33%;
			right: 33%;
		
		}
		
		.msg{
			font-size: 15px;
			margin-top: 3px;
		
		}
		
	</style>
	
	</head>
	<body>
		<h5>Bem vindo ao curso de JSP</h5>
		
		<form action="<%= request.getContextPath() %>/ServletLogin" method="post" class="row g-3 needs-validation" novalidate>
			<input type="hidden" value="<%= request.getParameter("url") %>" name="url">
				
				
				<div class="col-md-6">
					
					<label class="form-label">Login:</label>
					<input name="login" type="text" id="login" class="form-control" id="validationLogin" required>
					<div class="invalid-feedback">
						Tem que colocar o login:)
					</div>
					<div class="valid-feedback">
						Certinho:)
					</div>
				</div>
				
				<div class="col-md-6">
					
					<label class="form-label">Senha:</label>
					<input name="senha" type="password" id="senha" class="form-control" id="validationSenha" required>
					<div class="invalid-feedback">
						Tem que colocar a senha:)
					</div>
					<div class="valid-feedback">
						Certinho:)
					</div>
				</div>
				
				<div class="col-12 mt-1">
					
					<input type="submit" value="Acessar" class="btn btn-primary btn-block">	
					
				</div>
		<form/>
		
		<div class="col-12 alert" >
			<h6 class="msg alert-warning">${msg}</h6>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
		
		
		<script type="text/javascript">
			(() => {
			  'use strict'
	
			  const forms = document.querySelectorAll('.needs-validation')
	
			 
			  Array.from(forms).forEach(form => {
			    form.addEventListener('submit', event => {
			      if (!form.checkValidity()) {
			        event.preventDefault()
			        event.stopPropagation()
			      }
	
			      form.classList.add('was-validated')
			    }, false)
			  })
			})()
		
		</script>
		
	</body>
</html>