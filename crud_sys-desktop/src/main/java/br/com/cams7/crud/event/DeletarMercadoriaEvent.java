package br.com.cams7.crud.event;

import br.com.cams7.crud.entity.MercadoriaEntity;

/**
 * Evento deve ser gerado durante a exclusão de uma <code>Mercadoria</code>.
 * 
 * <p>
 * Recebe a referência da <code>Mercadoria</code> que foi removida.
 * </p>
 * 
 * @author YaW Tecnologia
 */
public class DeletarMercadoriaEvent extends AbstractEvent<MercadoriaEntity> {

	public DeletarMercadoriaEvent(MercadoriaEntity m) {
		super(m);
	}

}
