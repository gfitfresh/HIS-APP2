<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	
</script>

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js">
	
</script>


</head>

<body>

	<form:form action="create" method="POST"
		modelAttribute="adminEntity">

		<div class="container p-3 mb-2 bg-light text-dark">
	
		

			<div>
				<div>
					<h2>Create Account</h2>
				</div>
			</div>
			<br></br>

			<div class="row">
				<div class="col-4 ">
					<label for="fname"><b>First Name</b></label>
				</div>
				<div class="col-4 p-1">
					 <form:hidden path="regId" /> 
					<form:input type="text" class="form-control" 
						path="firstName" id="fname"/>
				</div>
			</div>

			<div class="row">
				<div class="col-4">
					<label for="lname"><b>Last Name</b></label>
				</div>

				<div class="col-4 p-1">
					<form:input type="text" class="form-control" path="lastName" id="lname"></form:input>
				</div>

			</div>

			<div class=" row">
				<div class="col-4">
					<label for="email"><b>Email Address</b></label>
				</div>
				<div class="col-4 p-1">
					<form:input type="email" class="form-control" id="email" path="email"></form:input>
				</div>

			</div>




			<div class="row">
				<div class="col-4">
					<label for="gen"><b>Gender</b></label>
				</div>

				<div class="col-4 p-1 ">
                 <form:radiobutton path="gender" value="male"/><b> MALE</b>
                 <form:radiobutton path="gender" value="female"/><b> FEMALE</b>                 
				</div>

			</div>
			
			<div class="row">
				<div class="col-4">
					<label for="role"><b>Role</b></label>
				</div>

				<div class="col-4 p-1">
					<form:select class="form-control" path="role">
						<form:option value="">Choose Role</form:option>
						<form:option value="Admin">Admin</form:option>
						<form:option value="CaseWorker">CaseWorker</form:option>						
					</form:select>
				</div>

			</div>
			
			<br></br>

			<div class="row">

				<div class="col-4 ">
					<input type="submit" value="Create"
						id="register">
				</div>

			</div>

			<br></br>
			<c:if test="${!empty msg}">
				<div>
					<h4>${msg}</h4>
					<h4>
						<a
							href="send?url=https://accounts.google.com/AccountChooser/signinchooser?flowName=GlifWebSignIn&flowEntry=AccountChooser/">Click
							here to Check your Mail</a>
					</h4>
				</div>
			</c:if>
		</div>

	</form:form>
</body>
</html>
