<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<c:if test="${param.mensaje eq 'correcto'}">
	<c:set var="mensajeOK" value="true" ></c:set>
</c:if>
<c:if test="${param.mensaje=='errorId'}">
 <c:set var="mensajeError" value="true" ></c:set>
</c:if>
    
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Profesores</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.Incluir mi codigo -->
            <div class="row">
            <div class="col-lg-12">
            	<div class="panel panel-default">
                        <c:if test="${mensajeOK}">
                             <div class="alert alert-success" id="mensaje">
                               Operación realizada correctamente
                            </div>
                        </c:if>
                        <c:if test="${mensajeError}">
                        	<div class="alert alert-danger" id="mensaje">
                               Id no encontrado. No es posible realizar la operación.
                            </div>
                        </c:if>
                            
                            
                        <div class="panel-heading">
                            Listado de Profesores
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
                                
                                <c:forEach var="profesor" items="${listado}"> 
                               
                                    <tr class="odd gradeX">
                                        <td>${profesor.nombre}</td>
                                        <td>${profesor.apellido1} ${profesor.apellido2}</td>
                                        <td>${profesor.nif}</td>
                                        <td>${profesor.telefono}</td>
                                        <td ><a href="${ruta}/admin/profesores/modificar.html?id=${profesor.id}">Modificar</a> <a href="#" onclick="confirmarEliminacion(${profesor.id})">Eliminar</a></td>
                                    </tr>
                              </c:forEach> 
                                </tbody>
                            </table>
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
            </div>
            
            
            </div>
	 <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true,
        });
        setTimeout(function() {
            $("#mensaje").toggle(2000);
        },3000);
    });
    
    
   
    </script>
	<script>
	function confirmarEliminacion(id){
		if (confirm("¿Está seguro que desea eliminar este profesor?")){
			location.href='${ruta}/admin/profesores/eliminar.html?id='+id;
		}
	}
	</script>
<style>

h1,h3 {
	text-align:center;
}
a {
	cursor:pointer;
}
.flotante {
	z-index: 999; border-radius:50px; border: 8px solid #fff; margin-top: -756px; margin-left: -153px; top: 50%; left: 50%; padding: 12px; position: fixed; width: 265px; background-color: #fff; border-radius: 3px;
}
</style>