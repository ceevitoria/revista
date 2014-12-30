package com.cee.revista.controller.jsf.recebimentoConfig;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.cee.revista.controller.jsf.AppMB;
import com.cee.revista.entity.config.RecebimentoConfigEntity;
import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

@PlcConfigAggregation(
	entity= com.cee.revista.entity.config.RecebimentoConfigEntity.class
)

@PlcConfigForm (
	formPattern=FormPattern.Apl,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/config/recebimento")
)

/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("recebimentoconfig")
@PlcHandleException
public class RecebimentoConfigMB extends AppMB  {

	private static final long serialVersionUID = 1L;
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("recebimentoconfig")
	public RecebimentoConfigEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new RecebimentoConfigEntity();
              this.newEntity();
        }
        
        return (RecebimentoConfigEntity)this.entityPlc;     	
	}
		
}
