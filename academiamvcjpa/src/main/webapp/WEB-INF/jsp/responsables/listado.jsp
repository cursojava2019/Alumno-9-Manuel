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
                    <h1 class="page-header">Responsables</h1>
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
                            Listado de Responsables
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
                                
                                <c:forEach var="responsable" items="${listado}"> 
                               
                                    <tr class="odd gradeX">
                                        <td>${responsable.nombre}</td>
                                        <td>${responsable.apellido1} ${responsable.apellido2}</td>
                                        <td>${responsable.nif}</td>
                                        <td>${responsable.telefono}</td>
                                        <td ><a href="${ruta}/admin/responsables/modificar.html?id=${responsable.id}">Modificar</a> <a href="#" onclick="confirmarEliminacion(${responsable.id})">Eliminar</a><a onmouseover="flotante(1,'${responsable.id}')" onmouseout="flotante(2,'${responsable.id}')"> Alumnos del responsable</a></td>
                                    </tr>
                              </c:forEach> 
                                </tbody>
                                
                                <c:forEach var="relacion" items="${listado}">
                                                
                                            <div class="flotante" id="flotante_${relacion.id}" >
                                                <c:forEach var="lista" items="${relacion.alumnos}">
                                                      Alumno: ${lista.nombre} ${lista.apellido1} ${lista.apellido2}<br>
                                                </c:forEach> 
                                                
                                           </div>       
                                     		
                                      </c:forEach> 
                                
                            </table>
						</div>
                        <!-- /.panel-body -->
                    </div>
            </div>
            
            
            </div>
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

<script>

function flotante(tipo, id){

	if (tipo==1){

	$('#flotante_'+id).animate({
      marginTop: "+50px",
      marginLeft: "-300px",
    },"slow");
	$('#contenedor').show();

	}
	if (tipo==2){
	$('#contenedor').fadeOut("slow");
	$('#flotante_'+id).animate({
	      marginTop: "-756px",
	      marginLeft: "-750px",
	},"slow");

}

}
</script>

<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
        setTimeout(function() {
            $("#mensaje").toggle(2000);
        },3000);
    });
</script>
<script>
	function confirmarEliminacion(id){
		if (confirm("¿Está seguro que desea eliminar este responsable?")){
			location.href='${ruta}/admin/responsables/eliminar.html?id='+id;
		}
	}
</script>