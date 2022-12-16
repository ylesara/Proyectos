<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Pacientes</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Consultorio Medico</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Agregar Paciente"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido Paterno</th>
					<th>Apellido Materno</th>
					<th>Correo</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempPaciente" items="${pacientes}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/paciente/showFormForUpdate">
						<c:param name="pacienteId" value="${tempPaciente.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/paciente/delete">
						<c:param name="pacienteId" value="${tempPaciente.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempPaciente.nombre} </td>
						<td> ${tempPaciente.apellidoP} </td>
						<td> ${tempPaciente.apellidoM} </td>
						<td> ${tempPaciente.correo} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Estas seguro de eliminar a este paciente?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









