<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Paciente</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-paciente-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Consultorio Medico</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar Paciente</h3>
	
		<form:form action="savePaciente" modelAttribute="paciente" method="POST">

			<!-- need to associate this data with paciente id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><form:input path="nombre" /></td>
					</tr>
				
					<tr>
						<td><label>Apellido Paterno:</label></td>
						<td><form:input path="apellidoP" /></td>
					</tr>
					
					<tr>
						<td><label>Apellido Materno:</label></td>
						<td><form:input path="apellidoM" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/paciente/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










