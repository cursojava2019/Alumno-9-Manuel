package es.indra.model.service;

import es.indra.model.dao.ClientesDao;
import es.indra.model.entities.Clientes;
import es.indra.model.support.Dao;
import es.indra.model.support.Service;

public class ClienteService extends Service<String, Clientes> {

	private ClientesDao dao = null;

	@Override
	protected Dao<String, Clientes> getDao() {
		if (this.dao == null) {
			this.dao = new ClientesDao();
		}
		return this.dao;
	}

}
