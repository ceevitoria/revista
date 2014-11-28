/* ************************* META-DADOS GLOBAIS DA APLICAÇÃO ******************************
  ********************** Configurações padrão para toda a aplicação *************************
  ************ Obs: configurações corporativas devem estar no nível anterior,****************
  ************              preferencialmente na camada Bridge               ****************
  *******************************************************************************************/


@PlcConfigApplication(
	definition=@PlcConfigApplicationDefinition(name="Controle dos Assinantes da Revista",acronym="Revista",version=1,release=0),
	classesDiscreteDomain={
		com.cee.revista.entity.StatusAssinatura.class, 
		com.cee.revista.entity.TipoOcorrencia.class},
	classesLookup={}
)


package com.powerlogic.jcompany.config.app;

import com.powerlogic.jcompany.config.application.PlcConfigApplication;
import com.powerlogic.jcompany.config.application.PlcConfigApplicationDefinition;
