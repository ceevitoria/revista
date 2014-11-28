package com.cee.revista.entity;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Access;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.AccessType;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name = "OCORRENCIA_ASSINATURA")
@SequenceGenerator(name = "SE_OCORRENCIA_ASSINATURA", sequenceName = "SE_OCORRENCIA_ASSINATURA")
@Access(AccessType.FIELD)
@NamedQueries({ @NamedQuery(name = "OcorrenciaEntity.querySelLookup", query = "select id as id, descricao as descricao from OcorrenciaEntity where id = ? order by id asc") })
public class OcorrenciaEntity extends Ocorrencia {

	private static final long serialVersionUID = 1L;

	/*
	 * Construtor padrao
	 */
	public OcorrenciaEntity() {
	}

	@Override
	public String toString() {
		return getDescricao();
	}

	@Transient
	private String indExcPlc = "N";

	public void setIndExcPlc(String indExcPlc) {
		this.indExcPlc = indExcPlc;
	}

	public String getIndExcPlc() {
		return indExcPlc;
	}

}
