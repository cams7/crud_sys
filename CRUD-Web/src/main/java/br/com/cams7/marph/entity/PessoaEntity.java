/**
 * 
 */
package br.com.cams7.marph.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.cams7.app.AbstractEntity;

/**
 * @author cesar
 *
 */
@Entity
@Table(name = "pessoa", uniqueConstraints = @UniqueConstraint(columnNames = "cpf") )
public class PessoaEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "pessoa_seq", sequenceName = "pessoa_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
	@Column(name = "id_pessoa")
	private Long id;

	@Column
	@NotEmpty
	@Size(min = 3, max = 45)
	private String nome;

	@Column
	@NotEmpty
	@Digits(fraction = 0, integer = 12)
	private String cpf;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Date nascimento;

	@OneToMany(mappedBy = "pessoa")
	private List<EnderecoEntity> enderecos;

	public PessoaEntity() {
		super();
	}

	public PessoaEntity(Long id) {
		super(id);
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public List<EnderecoEntity> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoEntity> enderecos) {
		this.enderecos = enderecos;
	}

}
