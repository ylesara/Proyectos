<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Paciente Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Consultorio Medico</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Agregar Paciente -->
			
			<input type="button" value="Agregar Paciente" 
				   onclick="window.location.href='add-paciente-form.html'; return false;"
				   class="add-paciente-button"
			/>
			
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Apellido Paterno</th>
					<th>Apellido Materno</th>
					<th>Correo</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempPaciente" items="${LISTA_PACIENTES}">
					
					<!-- set up a link for each paciente -->
					<c:url var="tempLink" value="PacienteControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="pacienteId" value="${tempPaciente.id}" />
					</c:url>

					<!--  set up a link to delete a paciente -->
					<c:url var="deleteLink" value="PacienteControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="pacienteId" value="${tempPaciente.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempPaciente.nombre} </td>
						<td> ${tempPaciente.apellidoPaterno} </td>
						<td> ${tempPaciente.apellidoMaterno} </td>
						<td> ${tempPaciente.correo} </td>
						<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('¿Estás seguro de eliminar éste paciente?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








