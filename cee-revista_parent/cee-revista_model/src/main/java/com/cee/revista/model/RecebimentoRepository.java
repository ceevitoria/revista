package com.cee.revista.model;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.cee.revista.entity.Assinatura;
import com.cee.revista.entity.AssinaturaEntity;
import com.cee.revista.entity.Ocorrencia;
import com.cee.revista.entity.OcorrenciaEntity;
import com.cee.revista.entity.StatusAssinatura;
import com.cee.revista.entity.TipoOcorrencia;
import com.cee.revista.entity.apoio.RegistroRecebimento;
import com.cee.revista.entity.config.RecebimentoConfig;
import com.cee.revista.entity.config.RecebimentoConfigEntity;
import com.cee.revista.entity.config.RetornoRegistro;
import com.cee.revista.entity.config.TipoMensagemSucessoConfig;
import com.cee.revista.persistence.jpa.assinatura.AssinaturaDAO;
import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.PlcException;
import com.powerlogic.jcompany.domain.type.PlcYesNo;

public class RecebimentoRepository {
	
	@Inject
	private AssinaturaDAO jpa;

	@Inject
	protected transient Logger log;

	private RecebimentoConfig config;
	private List<String> alertas = new ArrayList<String>();
	private List<String> mensagens = new ArrayList<String>();
	
	private PlcBaseContextVO context;
	
	/** 
	 * Registra a contribuição de um ou mais revista
	 * @param entityList
	 * @throws PlcException
	 */
	public RetornoRegistro registrarRecebimento(PlcBaseContextVO context, List entityList) throws PlcException {
		this.context = context;
		Date dataRecebimento = new Date();
		double valor = 0.0;

		mensagens.clear();
		alertas.clear();
		
		try {
			carregaConfiguracao(context);
			valor = registraRecebimento(entityList, dataRecebimento);
		} catch (PlcException plcE) {
			throw plcE;
		} catch (Exception e) {
			throw new PlcException("RecebimentoRepository", "registrarRecebimento", e, log, e.getMessage());
		}
		
		return new RetornoRegistro(BigDecimal.valueOf(valor), config, alertas, mensagens);
	}

	/**
	 * @param context
	 */
	private void carregaConfiguracao(PlcBaseContextVO context) throws PlcException {
		List listaConfig = (List)jpa.findAll(context, RecebimentoConfigEntity.class, null);
		
		if (listaConfig == null || listaConfig.size() != 1) {
			throw new PlcException("{erro.registrorecebimento.configuracao.inexistente}");
		}
		
		config = (RecebimentoConfig)listaConfig.get(0);
	}

	/**
	 * Configura como as mensagens serão apresentadas para o usuário
	 * @param listaObs
	 * @param valor
	 * @param quantidade
	 */
	private void configuraMensagens(List<String> listaObs, double valor, int quantidade) {
		if (valor == 0.0 || quantidade == 0) {
			alertas.add(String.format("Nenhuma contribuição registrada!"));
		} else {
			
			if (config.getExibirMensagemSucesso().equals(PlcYesNo.S) ) {
				
				if (config.getTipoMensagemSucesso() .equals(TipoMensagemSucessoConfig.B) ) {
					mensagens.add("Registro realizado com sucesso!");
				} else if (config.getTipoMensagemSucesso() .equals(TipoMensagemSucessoConfig.V) ){
					mensagens.add(String.format("Registro de %02d contribuicoes no valor total de R$ %,.02f realizado com sucesso!", new Object[]{quantidade, valor}));
				} else if (config.getTipoMensagemSucesso() .equals(TipoMensagemSucessoConfig.D) ){
					mensagens.add(String.format("Registro de %02d contribuicoes no valor total de R$ %,.02f realizado com sucesso!", new Object[]{quantidade, valor}));
					mensagens.addAll(listaObs);
				}
			}
		}
		
	}

	/**
	 * @param relacaoRecebimento
	 * @return
	 */
	private List<String> montaObservacao(List relacaoRecebimento) {
		List<String> listaObs = new ArrayList<String>();

		for (Object o : relacaoRecebimento) {
			RegistroRecebimento cl = (RegistroRecebimento)o;

			if (cl.getPessoa() != null && cl.getPessoa().getId() != null) {
				StringBuilder obs = new StringBuilder();
				obs.append("Pessoa: '");
				obs.append(cl.getPessoa().getNome());
				obs.append("' - Data: '");
				obs.append(DateFormat.getInstance().format(cl.getData()));
				obs.append("' - Valor: '");
				obs.append(String.format("R$ %,.02f", cl.getValor()));
				obs.append("'");

				listaObs.add(obs.toString());
			}
		}
		
		return listaObs;
	}

	/**
	 * Registra as contribuicoes para os itens da relação
	 * @param relacaoRecebimento Relação das contribuicoes a serem registradas
	 * @param dataRecebimento Data da contribuição, só será utilizada se a data informada pelo usuário não tiver sido informada.
	 * @return valorGeral A soma de todas as contribuições 
	 */
	private double registraRecebimento(@SuppressWarnings("rawtypes") List relacaoRecebimento, Date dataRecebimento) throws PlcException {
		double valorGeral = 0.0;
		int quantidade = 0;
		Assinatura assinatura = null;
		
		for (Object o : relacaoRecebimento) {
			RegistroRecebimento rc = (RegistroRecebimento)o;
			
			// Evita os itens em branco
			if (rc.getPessoa() != null && rc.getPessoa().getId() != null) {
				double valor = rc.getValor().doubleValue();
				
				List assocList = jpa.findByFields(context, AssinaturaEntity.class, "obterAssinaturaPorIdPessoa", new String[] {"idPessoa"}, new Object[] {rc.getPessoa().getId()});
				
				// Verifica se deve Cadastrar um novo revista
				if (assocList == null || assocList.size() == 0) {
					assinatura = new AssinaturaEntity();
					assinatura.setPessoa(rc.getPessoa());
					assinatura.setData(dataRecebimento);
					assinatura.setValor(rc.getValor());
					assinatura.setStatus(StatusAssinatura.A);
					assinatura.setSitHistoricoPlc("A");
					Long id = jpa.insert(context, assinatura);
					assinatura.setId(id);
					jpa.sendFlush(context);
				} else  {
					assinatura = (Assinatura)assocList.get(0);
				}
				
				
				// Utiliza a data atual caso não tenha sido informada
				rc.setData(rc.getData() != null ? rc.getData() : dataRecebimento);
				
				Ocorrencia ocorrencia = new OcorrenciaEntity();
				
				ocorrencia.setAssinatura(assinatura);
				ocorrencia.setTipo(TipoOcorrencia.RA);
				ocorrencia.setData(rc.getData());
				ocorrencia.setValor(rc.getValor());
				ocorrencia.setDescricao(rc.getDescricao());
				
				ocorrencia.setDataUltAlteracao(dataRecebimento);
				ocorrencia.setUsuarioUltAlteracao(context.getUserProfile().getLogin());
				
				jpa.insert(context, ocorrencia);
				
				valorGeral += valor;
				quantidade++;
			}
		}

		valorGeral = Math.round(valorGeral * 100.00) / 100.00;
		
		List<String> listaObs = montaObservacao(relacaoRecebimento);
		configuraMensagens(listaObs, valorGeral, quantidade);			
		
		return valorGeral;
	}
	
}
