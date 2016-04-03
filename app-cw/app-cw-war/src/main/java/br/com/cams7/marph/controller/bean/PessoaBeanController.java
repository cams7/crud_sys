/**
 * 
 */
package br.com.cams7.marph.controller.bean;

import static br.com.cams7.marph.controller.bean.PessoaBeanController.CONTROLLER_NAME;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.cams7.app.controller.AbstractBeanController;
import br.com.cams7.marph.entity.PessoaEntity;
import br.com.cams7.marph.service.PessoaService;

/**
 * @author cesar
 *
 */
@Controller(CONTROLLER_NAME)
@ManagedBean(name = CONTROLLER_NAME)
// @ViewScoped
@RequestScoped
public class PessoaBeanController extends AbstractBeanController<PessoaService, PessoaEntity> {

	private static final long serialVersionUID = 1L;

	public final static String CONTROLLER_NAME = "pessoaMB";

	private final String LIST_PAGE = "listaPessoas";

	public PessoaBeanController() {
		super("nome", "cpf");
	}

	/*
	 * Utiliza a injeção de dependência do <code>Spring Framework</code> para
	 * resolver a instância do <code>PessoaService</code>.
	 * 
	 * @see
	 * br.com.cams7.cw.controller.AbstractController#setService(br.com.cams7.app
	 * .service.BaseService)
	 */
	@Autowired
	@Override
	protected void setService(PessoaService service) {
		super.setService(service);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.app.controller.AbstractBeanController#createEntity()
	 */
	@Override
	public String createEntity() {
		String listPage = super.createEntity();

		addINFOMessage("Os dados pessoais foram cadastrados com sucesso!!!",
				String.format("Os dados pessoais de \"%s\" foram salvos.", getSelectedEntity().getNome()));

		return listPage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.app.controller.AbstractBeanController#updateEntity()
	 */
	@Override
	public void updateEntity() {
		super.updateEntity();

		addINFOMessage("Os dados pessoais foram atualizados com sucesso!!!",
				String.format("Os dados pessoais de \"%s\" foram atualizados.", getSelectedEntity().getNome()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.app.controller.AbstractBeanController#removeEntity()
	 */
	@Override
	public void removeEntity() {
		super.removeEntity();

		addINFOMessage("Os dados pessoais foram removidos com sucesso!!!",
				String.format("Os dados pessoais de \"%s\" foram removidos.", getSelectedEntity().getNome()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.app.controller.AbstractBeanController#getListPage()
	 */
	@Override
	protected String getListPage() {
		return LIST_PAGE;
	}

}