package com.cee.revista.controller.jsf.ocorrencia;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.cee.revista.commons.AppConstants;
import com.cee.revista.controller.jsf.AppMB;
import com.cee.revista.entity.AssinaturaEntity;
import com.powerlogic.jcompany.commons.PlcConstants;
import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

@PlcConfigAggregation(
	entity = com.cee.revista.entity.AssinaturaEntity.class, 
	
	details = {	
		@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(
			clazz = com.cee.revista.entity.OcorrenciaEntity.class,
			collectionName = "ocorrencia", numNew = 4,onDemand = false,
			navigation = @com.powerlogic.jcompany.config.aggregation.PlcConfigPagedDetail(numberByPage=30))
	}
)

@PlcConfigForm (
	formPattern=FormPattern.Mad,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/ocorrencia")
)

/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("ocorrencia")
@PlcHandleException
public class AssinaturaMB extends AppMB  {

	private static final long serialVersionUID = 1L;
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("assinaturaOcorrencia")
	public AssinaturaEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new AssinaturaEntity();
              this.newEntity();
        }
        return (AssinaturaEntity)this.entityPlc;     	
	}
		
	
	public void handleButtonsAccordingFormPattern() {
		String nomeAction = (String) contextUtil.getRequestAttribute(PlcConstants.PlcJsfConstantes.URL_COM_BARRA);
		
		if (nomeAction.contains("mad")) {
			contextUtil.getRequest().setAttribute(PlcConstants.ACAO.EXIBE_BT_ABRIR, PlcConstants.NAO_EXIBIR);
			contextUtil.getRequest().setAttribute("exibe_jcompany_evt_abrir", PlcConstants.NAO_EXIBIR);
			
			contextUtil.getRequest().setAttribute(AppConstants.ACAO.EXIBE_BT_ABRIR_CUSTOMIZADO, PlcConstants.EXIBIR);
			contextUtil.getRequest().setAttribute(AppConstants.URL_BT_ABRIR_CUSTOMIZADO, "assinaturasel");
		}
		
		super.handleButtonsAccordingFormPattern();
	}
	
}
