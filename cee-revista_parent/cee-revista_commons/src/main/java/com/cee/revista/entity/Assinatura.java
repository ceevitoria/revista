package com.cee.revista.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Enumerated;
import javax.persistence.OrderBy;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.GenerationType;
import org.hibernate.annotations.ForeignKey;
import javax.persistence.EnumType;
import javax.persistence.Temporal;
import javax.persistence.FetchType;
import javax.validation.constraints.Digits;
import javax.persistence.GeneratedValue;
import java.util.List;
import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;
import javax.validation.Valid;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@MappedSuperclass
public abstract class Assinatura extends AppBaseEntity {
	private static final long serialVersionUID = -6294603848506175347L;

	@OneToMany (targetEntity = com.cee.revista.entity.OcorrenciaEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="assinatura")
	@ForeignKey(name="FK_OCORRENCIA_ASSINATURA")
	@PlcValMultiplicity(referenceProperty="descricao",  message="{jcompany.aplicacao.mestredetalhe.multiplicidade.OcorrenciaEntity}")
	@OrderBy(value = "data")
	@Valid
	private List<Ocorrencia> ocorrencia;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_ASSINATURA")
	private Long id;

	@ManyToOne(targetEntity = PessoaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_ASSINATURA_PESSOA")
	@NotNull
	private Pessoa pessoa;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@NotNull
	@Digits(integer = 8, fraction = 2)
	private BigDecimal valor;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(length = 1)
	private StatusAssinatura status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date vigencia;

	@NotNull
	@Size(max = 1)
	private String sitHistoricoPlc = "A";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public StatusAssinatura getStatus() {
		return status;
	}

	public void setStatus(StatusAssinatura status) {
		this.status = status;
	}

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public String getSitHistoricoPlc() {
		return sitHistoricoPlc;
	}

	public void setSitHistoricoPlc(String sitHistoricoPlc) {
		this.sitHistoricoPlc = sitHistoricoPlc;
	}

	public List<Ocorrencia> getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(List<Ocorrencia> ocorrencia) {
		this.ocorrencia=ocorrencia;
	}

}
