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
@NamedQueries({ 
	@NamedQuery(name = "OcorrenciaEntity.querySel", query = "select obj.id as id, obj.tipo as tipo, obj.data as data, obj.valor as valor, obj.descricao as descricao, obj.versao as versao, obj1.id as assinatura_id, obj1.versao as assinatura_versao, obj2.id as assinatura_pessoa_id, obj2.nome as assinatura_pessoa_nome, obj2.versao as assinatura_pessoa_versao from OcorrenciaEntity obj inner join obj.assinatura obj1 inner join obj1.pessoa obj2 order by obj.data asc"),
	@NamedQuery(name = "OcorrenciaEntity.querySelLookup", query = "select obj.id as id, obj.data as data, obj.tipo as tipo, obj.descricao as descricao, obj1.id as assinatura_id, obj1.status as assinatura_status, obj2.id as assinatura_pessoa_id, obj2.nome as assinatura_pessoa_nome from OcorrenciaEntity obj inner join obj.assinatura obj1 inner join obj1.pessoa obj2 where obj.id = ? order by obj.data asc") })
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
