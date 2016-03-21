/**
 * 
 */
package br.com.cams7.marph.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.com.cams7.app.repository.AbstractRepository;
import br.com.cams7.marph.entity.PessoaEntity;

/**
 * @author cesar
 *
 */
@Repository
public class PessoaRepositoryImpl extends AbstractRepository<PessoaEntity> implements PessoaRepository {

	public PessoaRepositoryImpl() {
		super();
	}

	@Override
	public List<PessoaEntity> buscaPessoasSemUsuarioPeloNome(String nome) {
		Query query = getCurrentSession().getNamedQuery("Pessoa.buscaPessoasSemUsuarioPeloNome");
		query.setParameter("nome", "%" + nome + "%");
		query.setMaxResults(5);
		@SuppressWarnings("unchecked")
		List<PessoaEntity> pessoas = query.list();
		return pessoas;
	}

	@Override
	public List<PessoaEntity> buscaPeloNome(String nome) {
		Query query = getCurrentSession().getNamedQuery("Pessoa.buscaPeloNome");
		query.setParameter("nome", "%" + nome + "%");
		query.setMaxResults(5);
		@SuppressWarnings("unchecked")
		List<PessoaEntity> pessoas = query.list();
		return pessoas;
	}

}
