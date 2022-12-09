<%@ page import="java.util.*, com.luv2code.web.jdbc.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>Paciente Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%
	// get the students from the request object (sent by servlet)
	List<Paciente> thePacientes = 
					(List<Paciente>) request.getAttribute("PACIENTE_LIST");
%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Consultorio Medico</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Apellido Paterno</th>
					<th>Apellido Materno</th>
					<th>Correo</th>
				</tr>
				
				<% for (Paciente tempPaciente : thePacientes) { %>
				
					<tr>
						<td> <%= tempPaciente.getNombre() %> </td>
						<td> <%= tempPaciente.getApellidoPaterno() %> </td>
						<td> <%= tempPaciente.getApellidoMaterno() %> </td>
						<td> <%= tempPaciente.getCorreo() %> </td>
					</tr>
				
				<% } %>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








