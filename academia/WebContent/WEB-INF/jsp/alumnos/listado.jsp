<%@page import="java.util.ArrayList"%>
<%@page import="es.indra.academia.model.entities.Alumno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	List<Alumno> listado=(List<Alumno>)request.getAttribute("listado");
	if (listado==null){
		listado=new ArrayList<Alumno>();
	}
%>    
    
    
<!DOCTYPE html>
<html>
<%@include file="../plantilla/head.jsp" %>
<body>

    <div id="wrapper">

        <!-- Navigation -->
        <%@include file="../plantilla/cabecera.jsp" %>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Alumnos</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.Incluir mi codigo -->
            <div class="row">
            <div class="col-lg-12">
            	<div class="panel panel-default">
                        <div class="panel-heading">
                            Listado de Alumnos
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                           <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Apellidos</th>
                                        <th>DNI</th>
                                        <th>Telefono</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <% for(int i=0; i<listado.size();i++) {
                                	Alumno alumno=listado.get(i);	
                                %>
                                    <tr class="odd gradeX">
                                        <td><%=alumno.getNombre()%></td>
                                        <td><%=alumno.getApellido1()%> <%=alumno.getApellido2()%></td>
                                        <td><%=alumno.getNif()%></td>
                                        <td ><%=alumno.getTelefono()%></td>
                                        <td ><a href="<%=alumno.getId()%>">Modificar</a> <a href="<%=alumno.getId()%>">Eliminar</a></td>
                                    </tr>
                                <% } %>   
                                </tbody>
                            </table>
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
            </div>
            
            
            </div>
            
            
            
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

   <%@include file="../plantilla/javascriptPie.jsp" %>
	 <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>
	
</body>
</html>