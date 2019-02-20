package es.indra.academia.controller.responsable;

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

import es.indra.academia.controller.responsable.ResponsableFormValidator;
import es.indra.academia.controller.responsable.ResponsableRestController;
import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.service.ResponsableJpaService;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.ServiceException;

@RestController
public class ResponsableRestController {
	@Autowired
	private ResponsableJpaService responsableService;
	@Autowired
	ResponsableFormValidator validador;
	private Logger log = LogManager.getLogger(ResponsableRestController.class);

	@Transactional
	@RequestMapping(value = "/responsables/", method = RequestMethod.GET)
	public ResponseEntity<List<ResponsableAlumno>> listar() throws ServiceException, DaoException {
		List<ResponsableAlumno> listado = this.responsableService.buscarTodos();
		if (listado.isEmpty()) {
			return new ResponseEntity<List<ResponsableAlumno>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ResponsableAlumno>>(listado, HttpStatus.OK);
		}
	}

	@Transactional
	@RequestMapping(value = "/responsables/{id}", method = RequestMethod.GET)
	public ResponseEntity<ResponsableAlumno> obtenerResponsable(@PathVariable("id") Long id) throws ServiceException, DaoException {

		ResponsableAlumno a = this.responsableService.buscar(id);

		if (a == null) {
			return new ResponseEntity<ResponsableAlumno>(HttpStatus.NO_CONTENT);
		} else {
			a.getId();
			return new ResponseEntity<ResponsableAlumno>(a, HttpStatus.OK);
		}
	}

	@Transactional
	@RequestMapping(value = "/responsables/", method = RequestMethod.POST)
	public ResponseEntity<Void> crearResponsable(@RequestBody ResponsableAlumno responsable, BindingResult bindingResult,
			UriComponentsBuilder ucBuilder) throws ServiceException, DaoException {
		this.responsableService.crear(responsable);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/responsables/{id}").buildAndExpand(responsable.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@Transactional
	@RequestMapping(value = "/responsables/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ResponsableAlumno> actualizarResponsable(@PathVariable("id") long id, @RequestBody ResponsableAlumno responsable) throws ServiceException, DaoException {
		System.out.println("Updating User " + id);

		ResponsableAlumno currentResponsable = this.responsableService.buscar(id);

		if (currentResponsable == null) {
			;
			return new ResponseEntity<ResponsableAlumno>(HttpStatus.NOT_FOUND);
		}

		currentResponsable.setNombre(responsable.getNombre());
		currentResponsable.setApellido1(responsable.getApellido1());
		currentResponsable.setApellido2(responsable.getApellido2());
		currentResponsable.setNif(responsable.getNif());
		currentResponsable.setTelefono(responsable.getTelefono());
		currentResponsable.setCorreo(responsable.getCorreo());

		this.responsableService.modificar(currentResponsable);
		return new ResponseEntity<ResponsableAlumno>(currentResponsable, HttpStatus.OK);
	}

	@RequestMapping(value = "/responsables/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ResponsableAlumno> deleteUser(@PathVariable("id") Long id) throws ServiceException, DaoException {
		ResponsableAlumno currentResponsable = this.responsableService.buscar(id);
		if (currentResponsable == null) {
			;
			return new ResponseEntity<ResponsableAlumno>(HttpStatus.NOT_FOUND);
		}
		this.responsableService.eliminarById(id);
		return new ResponseEntity<ResponsableAlumno>(HttpStatus.NO_CONTENT);
	}
}
