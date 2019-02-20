<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>



   
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Responsable de Alumnos</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.Incluir mi codigo -->
            <div class="row">
            <div class="col-lg-12">
            	<div class="panel panel-default">     
                        <div class="panel-heading">
                            Detalles del responsable ${responsable.nombre}
                        </div>
                        
                        <form name="buscador" action="./listado.html" method="post">
                        <div class="">
                        <div class="panel-body">
                           <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <h2><b>Alumnos Asignados:</b></h2>h2>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Apellidos</th>
                                        <th>DNI</th>
                                        <th>Telefono</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="responsable" items="${listado}"> 
                               
                                    <tr class="odd gradeX">
                                        <td>${responsable.nombre}</td>
                                        <td>${responsable.apellido1} ${responsable.apellido2}</td>
                                        <td>${responsable.nif}</td>
                                        <td>${responsable.telefono}</td>
                                        
                                    </tr>
                              </c:forEach>   
                                </tbody>
                               
                            </table>
                             <button class="btn btn-default" onclick="location.href='${ruta}/admin/responsable/detalles.html?id=${responsable.id}';" type="button">
                                         	  <b>Detalles</b>	
                                         	</button></td>
                        </div>
                        <!-- /.panel-body -->
                    </div>
            </div>
            
            
            </div>
            

        
  

   
	
