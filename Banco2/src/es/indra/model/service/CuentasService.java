package es.indra.model.service;

import es.indra.model.dao.CuentasDao;
import es.indra.model.entities.Cuentas;
import es.indra.model.support.Dao;
import es.indra.model.support.Service;

public class CuentasService extends Service<String, Cuentas> {

	private CuentasDao dao = null;

	@Override
	protected Dao<String, Cuentas> getDao() {
		if (this.dao == null) {
			this.dao = new CuentasDao();
		}
		return this.dao;
	}

}
