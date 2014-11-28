package com.cee.revista.controller.jsf.assinatura;

import javax.enterprise.inject.Produces;
import javax.inject.Named;


import com.cee.revista.entity.AssinaturaEntity;
import com.cee.revista.controller.jsf.AppMB;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.config.collaboration.FormPattern;

import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm.ExclusionMode;



 
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;

@PlcConfigAggregation(
	entity = com.cee.revista.entity.AssinaturaEntity.class
)
	


@PlcConfigForm (
	formPattern=FormPattern.Man,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/assinatura"), 
	exclusionMode=ExclusionMode.LOGICAL
)

/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("assinatura")
@PlcHandleException
public class AssinaturaMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("assinatura")
	public AssinaturaEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new AssinaturaEntity();
              this.newEntity();
        }

        return (AssinaturaEntity)this.entityPlc;     	
	}
		
}
