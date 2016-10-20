package org.ksoft.matriculas.repositorio.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.marcaconsultoria.paginacion.PaginacionTablaGenericaImpl;

/**
 * Adaptación de la paginación al proyecto de seguimiento
 * 
 * @author RCHZ
 *
 * @param <ENTIDAD>
 */
public class PaginacionTablaGenericaMatriculasImpl<ENTIDAD> extends PaginacionTablaGenericaImpl<ENTIDAD> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7576187188710925412L;

	public PaginacionTablaGenericaMatriculasImpl() throws InstantiationException, IllegalAccessException {
		super();
	}

	@Override
	@PersistenceContext(name = "entityManagerFactory", unitName = "matriculas")
	public void setEntityManager(EntityManager entityManager) {
		super.setEntityManager(entityManager);
	}

}
