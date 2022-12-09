<!DOCTYPE html>
<html>

<head>
	<title>Update Paciente</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-paciente-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Consultorio Medico</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update Paciente</h3>
		
		<form action="PacienteControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="pacienteId" value="${THE_PACIENTE.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="nombre" 
								   value="${THE_PACIENTE.nombre}" /></td>
					</tr>

					<tr>
						<td><label>Apellido Paterno:</label></td>
						<td><input type="text" name="apellidoPaterno" 
								   value="${THE_PACIENTE.apellidoPaterno}" /></td>
					</tr>
					
					<tr>
						<td><label>Apellido Materno:</label></td>
						<td><input type="text" name="apellidoMaterno" 
								   value="${THE_PACIENTE.apellidoMaterno}" /></td>
					</tr>

					<tr>
						<td><label>Correo:</label></td>
						<td><input type="text" name="correol" 
								   value="${THE_PACIENTE.correo}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="PacienteControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











