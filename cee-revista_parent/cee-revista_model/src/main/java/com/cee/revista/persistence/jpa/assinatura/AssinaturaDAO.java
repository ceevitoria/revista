package com.cee.revista.persistence.jpa.assinatura;

import com.cee.revista.persistence.jpa.AppJpaDAO;
import com.cee.revista.entity.AssinaturaEntity;
import com.cee.revista.entity.Pessoa;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;
import java.util.Date;
import java.math.BigDecimal;
import com.cee.revista.entity.StatusAssinatura;

import java.util.List;

import com.powerlogic.jcompany.persistence.jpa.PlcQuery;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryLineAmount;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryOrderBy;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryFirstLine;
import com.powerlogic.jcompany.commons.annotation.PlcAggregationDAOIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcDataAccessObject;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryService;
import com.powerlogic.jcompany.commons.PlcBaseContextVO;
/**
 * Classe de Persistência gerada pelo assistente
 */

@PlcAggregationDAOIoC(AssinaturaEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class AssinaturaDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<AssinaturaEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="pessoa", expression="obj1 = :pessoa") Pessoa pessoa,
			@PlcQueryParameter(name="data", expression="obj.data >= :data  ") Date data,
			@PlcQueryParameter(name="valor", expression="obj.valor = :valor") BigDecimal valor,
			@PlcQueryParameter(name="status", expression="obj.status = :status") StatusAssinatura status
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="pessoa", expression="obj1 = :pessoa") Pessoa pessoa,
			@PlcQueryParameter(name="data", expression="obj.data >= :data  ") Date data,
			@PlcQueryParameter(name="valor", expression="obj.valor = :valor") BigDecimal valor,
			@PlcQueryParameter(name="status", expression="obj.status = :status") StatusAssinatura status
	);
	
}
