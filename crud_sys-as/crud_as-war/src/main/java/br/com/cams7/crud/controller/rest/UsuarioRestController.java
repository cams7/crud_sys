/**
 * 
 */
package br.com.cams7.crud.controller.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.cams7.crud.as.controller.rest.AbstractRestController;
import br.com.cams7.crud.entity.UsuarioEntity;
import br.com.cams7.crud.service.UsuarioService;

/**
 * @author cesar
 *
 */
@Path("/usuario")
@Produces(APPLICATION_JSON)
@RequestScoped
public class UsuarioRestController extends AbstractRestController<UsuarioService, UsuarioEntity> {

	@EJB
	private UsuarioService service;

	public UsuarioRestController() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.app.controller.AbstractController#getService()
	 */
	@Override
	protected UsuarioService getService() {
		return service;
	}

}
