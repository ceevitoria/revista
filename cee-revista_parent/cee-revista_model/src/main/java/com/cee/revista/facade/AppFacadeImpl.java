package com.cee.revista.facade;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.PlcException;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcFacade;
import com.powerlogic.jcompany.facade.PlcFacadeImpl;
import com.powerlogic.jcompany.model.annotation.PlcTransactional;
import com.cee.revista.entity.config.RetornoRegistro;
import com.cee.revista.model.RecebimentoRepository;
import com.cee.revista.facade.IAppFacade;

@QPlcDefault
@SPlcFacade
public class AppFacadeImpl extends PlcFacadeImpl implements IAppFacade{

	@Inject
	private RecebimentoRepository recebimentoRepository;
	
	@PlcTransactional(commit=true)
	@TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
	@Override
	public RetornoRegistro registrarRecebimento(PlcBaseContextVO context, List entityList) throws PlcException {
		return recebimentoRepository.registrarRecebimento(context, entityList);
	}
		
}
