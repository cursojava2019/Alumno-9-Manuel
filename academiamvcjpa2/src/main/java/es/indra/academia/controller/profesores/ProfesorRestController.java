package es.indra.academia.controller.profesores;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import es.indra.academia.model.entities.Profesor;
import es.indra.academia.model.service.ProfesorJpaService;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.ServiceException;

@RestController
public class ProfesorRestController {
	@Autowired
	private ProfesorJpaService profesorService;
	@Autowired
	ProfesorFormValidator validador;
	private Logger log = LogManager.getLogger(ProfesorRestController.class);

	@Transactional
	@RequestMapping(value = "/profesores/", method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> listar() throws ServiceException, DaoException {
		List<Profesor> listado = this.profesorService.buscarTodos();
		if (listado.isEmpty()) {
			return new ResponseEntity<List<Profesor>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Profesor>>(listado, HttpStatus.OK);
		}
	}

	@Transactional
	@RequestMapping(value = "/profesores/{id}", method = RequestMethod.GET)
	public ResponseEntity<Profesor> obtenerAlumno(@PathVariable("id") Long id) throws ServiceException, DaoException {

		Profesor a = this.profesorService.buscar(id);

		if (a == null) {
			return new ResponseEntity<Profesor>(HttpStatus.NO_CONTENT);
		} else {
			a.getId();
			return new ResponseEntity<Profesor>(a, HttpStatus.OK);
		}
	}

	@Transactional
	@RequestMapping(value = "/profesores/", method = RequestMethod.POST)
	public ResponseEntity<Void> crearAlumno(@RequestBody Profesor profesor, BindingResult bindingResult,
			UriComponentsBuilder ucBuilder) throws ServiceException, DaoException {
		this.profesorService.crear(profesor);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/profesores/{id}").buildAndExpand(profesor.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@Transactional
	@RequestMapping(value = "/profesores/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Profesor> actualizarAlumno(@PathVariable("id") long id, @RequestBody Profesor profesor) throws ServiceException, DaoException {
		System.out.println("Updating User " + id);

		Profesor currentProfesor = this.profesorService.buscar(id);

		if (currentProfesor == null) {
			;
			return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
		}

		currentProfesor.setNombre(profesor.getNombre());
		currentProfesor.setApellido1(profesor.getApellido1());
		currentProfesor.setApellido2(profesor.getApellido2());
		currentProfesor.setCorreo(profesor.getCorreo());

		this.profesorService.modificar(currentProfesor);
		return new ResponseEntity<Profesor>(currentProfesor, HttpStatus.OK);
	}

	@RequestMapping(value = "/profesor/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Profesor> deleteUser(@PathVariable("id") Long id) throws ServiceException, DaoException {
		Profesor currentAlumno = this.profesorService.buscar(id);
		if (currentAlumno == null) {
			;
			return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
		}
		this.profesorService.eliminarById(id);
		return new ResponseEntity<Profesor>(HttpStatus.NO_CONTENT);
	}


}
