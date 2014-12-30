package com.cee.revista.facade;

import java.util.List;

import com.cee.revista.entity.config.RetornoRegistro;
import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.PlcException;
import com.powerlogic.jcompany.commons.facade.IPlcFacade;

public interface IAppFacade extends IPlcFacade{

	/**
	 * Registra o recebimento da assinatura de um ou mais assinante da revista
	 * @param context Contexto da aplicacao
	 * @param entityList Relacao dos recebimentos sendo registrados
	 * @return RetornoRegistro Retorna com informacoes sobre o registro do recebimento(@see RetornoRegistro)
	 */
	public RetornoRegistro registrarRecebimento(PlcBaseContextVO context, List entityList) throws PlcException;
	
}
