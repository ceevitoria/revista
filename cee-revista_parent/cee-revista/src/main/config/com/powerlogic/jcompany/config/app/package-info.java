/* ************************* META-DADOS GLOBAIS DA APLICAÇÃO ******************************
  ********************** Configurações padrão para toda a aplicação *************************
  ************ Obs: configurações corporativas devem estar no nível anterior,****************
  ************              preferencialmente na camada Bridge               ****************
  *******************************************************************************************/


@PlcConfigApplication(
	definition=@PlcConfigApplicationDefinition(name="Assinantes da Revista",acronym="Revista",version=1,release=0),
	classesDiscreteDomain={
		com.powerlogic.jcompany.domain.type.PlcYesNo.class,
		com.cee.revista.entity.Sexo.class,
		com.cee.revista.entity.StatusAssinatura.class, 
		com.cee.revista.entity.TipoOcorrencia.class,
		com.cee.revista.entity.config.TipoMensagemSucessoConfig.class},
	classesLookup={
		com.cee.revista.entity.UfEntity.class,
		com.cee.revista.entity.CidadeEntity.class}
)


package com.powerlogic.jcompany.config.app;

import com.powerlogic.jcompany.config.application.PlcConfigApplication;
import com.powerlogic.jcompany.config.application.PlcConfigApplicationDefinition;
