package com.cee.revista.controller.jsf.pessoa;

import javax.enterprise.inject.Produces;
import javax.inject.Named;


import com.cee.revista.entity.PessoaEntity;
import com.cee.revista.controller.jsf.AppMB;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.config.collaboration.FormPattern;

import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm.ExclusionMode;

//import com.powerlogic.jcompany.config.collaboration.PlcConfigNestedCombo; 
 
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;

@PlcConfigAggregation(
		entity = com.cee.revista.entity.PessoaEntity.class
		,components = {@com.powerlogic.jcompany.config.aggregation.PlcConfigComponent(
				clazz=com.cee.revista.entity.Endereco.class, property="endereco", separate=true)}
	)
	
@PlcConfigForm (
//	nestedCombo=@PlcConfigNestedCombo(origemProp="endereco.uf", destinyProp="endereco.cidade"),
	formPattern=FormPattern.Man,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/pessoa")
	,exclusionMode=ExclusionMode.LOGICAL
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("pessoa")
@PlcHandleException
public class PessoaMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("pessoa")
	public PessoaEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new PessoaEntity();
              this.newEntity();
        }
        return (PessoaEntity)this.entityPlc;     	
	}
		
}
