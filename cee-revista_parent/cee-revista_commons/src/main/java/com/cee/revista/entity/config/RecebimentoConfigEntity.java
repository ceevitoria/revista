package com.cee.revista.entity.config;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import com.powerlogic.jcompany.domain.type.PlcYesNo;
import javax.persistence.Access;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.AccessType;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
import javax.persistence.Entity;

/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name = "RECEBIMENTO_CONFIG")
@SequenceGenerator(name = "SE_RECEBIMENTO_CONFIG", sequenceName = "SE_RECEBIMENTO_CONFIG")
@Access(AccessType.FIELD)
@NamedQueries({ @NamedQuery(name = "RecebimentoConfigEntity.querySelLookup", query = "select id as id, exibirMensagemSucesso as exibirMensagemSucesso from RecebimentoConfigEntity where id = ? order by id asc") })
public class RecebimentoConfigEntity extends RecebimentoConfig {

	private static final long serialVersionUID = 1L;

	/*
	 * Construtor padrao
	 */
	public RecebimentoConfigEntity() {
	}

	@Override
	public String toString() {
		return getExibirMensagemSucesso().toString();
	}

}
