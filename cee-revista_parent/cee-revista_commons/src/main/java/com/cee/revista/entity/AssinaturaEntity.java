package com.cee.revista.entity;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "ASSINATURA")
@SequenceGenerator(name = "SE_ASSINATURA", sequenceName = "SE_ASSINATURA")
@Access(AccessType.FIELD)
@NamedQueries({
	@NamedQuery(name="AssinaturaEntity.queryMan", query="from AssinaturaEntity where sitHistoricoPlc='A'"),
	@NamedQuery(name="AssinaturaEntity.queryEdita", query="select obj from AssinaturaEntity obj where obj.id = ? and obj.sitHistoricoPlc='A'"),
	@NamedQuery(name="AssinaturaEntity.naoDeveExistirPessoa", query = "select count(obj) from AssinaturaEntity obj where obj.pessoa = :pessoa and obj.sitHistoricoPlc='A'"),
	@NamedQuery(name="AssinaturaEntity.obterAssinaturaPorIdPessoa", query = "from AssinaturaEntity where pessoa.id = :idPessoa and sitHistoricoPlc='A'"),
	@NamedQuery(name="AssinaturaEntity.querySel", query="select obj.id as id, obj1.id as pessoa_id, obj1.nome as pessoa_nome, obj.data as data, obj.valor as valor, obj.status as status from AssinaturaEntity obj left outer join obj.pessoa as obj1 where obj.sitHistoricoPlc='A' order by obj1.nome asc"), 
	@NamedQuery(name="AssinaturaEntity.querySelLookup", query = "select obj.id as id, obj1.id as pessoa_id, obj1.nome as pessoa_nome from AssinaturaEntity obj inner join obj.pessoa obj1 where obj.id = ? and obj.sitHistoricoPlc='A' order by obj1.nome asc") })
public class AssinaturaEntity extends Assinatura {
	private static final long serialVersionUID = 8423440772616150007L;

	/*
	 * Construtor padrao
	 */
	public AssinaturaEntity() {
	}

	@Override
	public String toString() {
		return getPessoa().toString();
	}

}
