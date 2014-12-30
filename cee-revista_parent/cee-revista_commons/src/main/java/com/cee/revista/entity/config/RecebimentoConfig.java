package com.cee.revista.entity.config;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import com.powerlogic.jcompany.domain.type.PlcYesNo;

@MappedSuperclass
public abstract class RecebimentoConfig extends Config {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_RECEBIMENTO_CONFIG")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(length = 1)
	private PlcYesNo autoLimparTelaParaNovoRecebimento = PlcYesNo.S;

	@Enumerated(EnumType.STRING)
	@Column(length = 1)
	private PlcYesNo exibirMensagemSucesso = PlcYesNo.S;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(length = 1)
	private TipoMensagemSucessoConfig tipoMensagemSucesso = TipoMensagemSucessoConfig.V;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PlcYesNo getAutoLimparTelaParaNovoRecebimento() {
		return autoLimparTelaParaNovoRecebimento;
	}

	public void setAutoLimparTelaParaNovoRecebimento(
			PlcYesNo autoLimparTelaParaNovoRecebimento) {
		this.autoLimparTelaParaNovoRecebimento = autoLimparTelaParaNovoRecebimento;
	}

	public PlcYesNo getExibirMensagemSucesso() {
		return exibirMensagemSucesso;
	}

	public void setExibirMensagemSucesso(
			PlcYesNo exibirMensagemSucesso) {
		this.exibirMensagemSucesso = exibirMensagemSucesso;
	}

	public TipoMensagemSucessoConfig getTipoMensagemSucesso() {
		return tipoMensagemSucesso;
	}

	public void setTipoMensagemSucesso(
			TipoMensagemSucessoConfig tipoMensagemSucesso) {
		this.tipoMensagemSucesso = tipoMensagemSucesso;
	}

}
