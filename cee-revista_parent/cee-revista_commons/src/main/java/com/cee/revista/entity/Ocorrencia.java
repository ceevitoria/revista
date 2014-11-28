package com.cee.revista.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import org.apache.myfaces.extensions.validator.crossval.annotation.RequiredIfType;
import javax.persistence.TemporalType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.GenerationType;
import org.hibernate.annotations.ForeignKey;
import com.powerlogic.jcompany.domain.validation.PlcValGroupEntityList;
import org.apache.myfaces.extensions.validator.crossval.annotation.RequiredIf;
import javax.persistence.EnumType;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;
import javax.persistence.FetchType;
import javax.validation.constraints.Digits;
import javax.persistence.GeneratedValue;

@MappedSuperclass
public abstract class Ocorrencia extends AppBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_OCORRENCIA_ASSINATURA")
	private Long id;

	@ManyToOne(targetEntity = AssinaturaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_OCORRENCIA_ASSINATURA")
	@NotNull
	private Assinatura assinatura;

	@NotNull(groups = PlcValGroupEntityList.class)
	@RequiredIf(valueOf = "descricao", is = RequiredIfType.not_empty)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Enumerated(EnumType.STRING)
	@NotNull(groups = PlcValGroupEntityList.class)
	@RequiredIf(valueOf = "descricao", is = RequiredIfType.not_empty)
	@Column(length = 200)
	private TipoOcorrencia tipo;

	@Digits(integer = 8, fraction = 2)
	private BigDecimal valor;

	@Size(max = 200)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoOcorrencia getTipo() {
		return tipo;
	}

	public void setTipo(TipoOcorrencia tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Assinatura getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(Assinatura assinatura) {
		this.assinatura = assinatura;
	}

}
