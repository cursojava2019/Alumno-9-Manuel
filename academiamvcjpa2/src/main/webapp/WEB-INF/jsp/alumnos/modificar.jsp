<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Modificar Alumno</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.Incluir mi codigo -->
            <div class="row">
            <div class="col-lg-12">
              <div class="panel panel-default">
                        <div class="panel-heading">
                            Formulario de Modificacion
                        </div>
                        <div class="panel-body">
                        
                            <div class="row">
                                <div class="col-lg-6">
                                                          			 
                           			<form:form action="./modificar.html" method="post" modelAttribute="formulario" >
                                    	<form:hidden path="id" />
                                       
                                        <div class="form-group">
                                            <label>NIF</label>
                                           <form:input path="nif" class="form-control"/>
                                           <form:errors path="nif" element="div" cssClass="alert alert-danger"/>
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Nombre</label>
                                             <form:input path="nombre" class="form-control"/>
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Primer Apellido </label>
                                            <form:input path="apellido1" class="form-control"/>
                                            
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Segundo Apellido</label>
                                             <form:input path="apellido2" class="form-control"/>
                                            
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Telefono</label>
                                             <form:input path="telefono" class="form-control"/>
                                            
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Correo</label>
                                             <form:input path="correo" class="form-control"/>
                                            <p class="help-block"></p>
                                        </div>
                                        
                                   	    <div class="form-group">
                                   	    <label>Responsables:</label>
    	                                   		<form:select path="responsable" cssClass="form-control">
    	                                   			<form:option value="${formulario.responsable}" label="${formulario.responsable.nombre}" />
    	                                   			<form:options  var="listado" items="${listado}" itemValue="id" itemLabel="nombre" />	
												</form:select>
                                        </div>
                                        
                                        
                                        <c:if test="${formulario.repetidor==true}">
                                        <c:set var="chequeado" value="checked"> 
                                        </c:set> </c:if>
                                        <div class="form-group">
                                            <div class="checkbox">
                                                <label>
                                                    <form:checkbox path="repetidor"/>
                                                    Repetidor
                                                </label>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Observaciones:<br></label>
                                            <form:textarea path="observaciones" rows="3"/>
                                            
                                        </div>
                                      		
                                        <button type="submit" class="btn btn-default">Enviar</button>
                                        <button type="reset" class="btn btn-default">Limpiar</button>
                                   
                                    </form:form>
                                </div>
                               
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
            
            </div>
            
            
            </div>
            
            
            
      