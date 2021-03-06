/**
 * 
 */
package br.com.cams7.crud.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

//import org.springframework.stereotype.Repository;

import br.com.cams7.crud.entity.PessoaEntity;
import br.com.cams7.crud.entity.UsuarioEntity;
import br.com.cams7.crud.entity.UsuarioEntity_;
import br.com.cams7.sys.SearchParams;
import br.com.cams7.sys.repository.AbstractRepository;

/**
 * @author cesar
 *
 */
//@Repository
public class UsuarioRepositoryImpl extends AbstractRepository<UsuarioEntity> implements UsuarioRepository {

	public UsuarioRepositoryImpl() {
		super();
	}

	/*
	 * Filtra, pagina e ordena os objetos que são instâncias da classe
	 * "UsuarioEntity"
	 * 
	 * @see
	 * br.com.cams7.cw.repository.AbstractRepository#search(br.com.cams7.sys.
	 * SearchParams)
	 */
	@Override
	public List<UsuarioEntity> search(SearchParams params) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<UsuarioEntity> cq = cb.createQuery(getEntityType());

		Root<UsuarioEntity> from = cq.from(getEntityType());
		@SuppressWarnings("unchecked")
		Join<UsuarioEntity, PessoaEntity> join = (Join<UsuarioEntity, PessoaEntity>) from.fetch(UsuarioEntity_.pessoa,
				JoinType.LEFT);

		TypedQuery<UsuarioEntity> tq = getFilterAndPaginationAndSorting(cb, cq, join, params);
		List<UsuarioEntity> entities = tq.getResultList();
		return entities;
	}

	/*
	 * Retorna o numero total de instâncias da classe "UsuarioEntity". Essa
	 * pesquisa é feita com auxilio de filtros
	 * 
	 * @see
	 * br.com.cams7.cw.repository.AbstractRepository#getTotalElements(java.util.
	 * Map, java.lang.String[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int getTotalElements(Map<String, Object> filters, String... globalFilters) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);

		Root<UsuarioEntity> from = cq.from(getEntityType());
		Join<UsuarioEntity, PessoaEntity> join = from.join(UsuarioEntity_.pessoa, JoinType.LEFT);

		cq = (CriteriaQuery<Long>) getFilter(cb, cq, join, filters, globalFilters);
		int count = getCount(cb, cq, join);

		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.cw.repository.AbstractRepository#count()
	 */
	@Override
	public int count() {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);

		Root<UsuarioEntity> from = cq.from(getEntityType());
		Join<UsuarioEntity, PessoaEntity> join = from.join(UsuarioEntity_.pessoa, JoinType.LEFT);

		int count = getCount(cb, cq, join);

		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.cams7.crud.repository.UsuarioRepository#buscaTodosDadosPessoais()
	 */
	@Override
	public List<UsuarioEntity> getTodosDadosPessoais() {
		Query query = getEntityManager().createNamedQuery("Usuario.buscaTodosDadosPessoais");
		@SuppressWarnings("unchecked")
		List<UsuarioEntity> usuarios = query.getResultList();
		return usuarios;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.crud.repository.UsuarioRepository#
	 * loginFoiCadastradoAnteriormente(java.lang.String)
	 */
	@Override
	public boolean isLoginCadastradoAnteriormente(String login) {
		Query query = getEntityManager().createNamedQuery("Usuario.buscaQtdCadastradoPeloLogin");
		query.setParameter("login", login);

		Long count = (Long) query.getSingleResult();
		if (count.equals(0l))
			return false;

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.cams7.crud.repository.UsuarioRepository#buscaLoginPeloId(java.lang
	 * .Long)
	 */
	@Override
	public String getLoginPeloId(Long id) {
		Query query = getEntityManager().createNamedQuery("Usuario.buscaLoginPeloId");
		query.setParameter("id", id);

		return (String) query.getSingleResult();
	}

}
