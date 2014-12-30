package com.cee.revista.entity;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoOcorrencia {
    
	EA("{tipoOcorrencia.EA}"),  // Entrega Atrasada
	NR("{tipoOcorrencia.NR}"),  // Não Recebimento
	RA("{tipoOcorrencia.RA}"),  // Renovação Assinatura
	CA("{tipoOcorrencia.CA}"),  // Cancelamento Assinatura
	OU("{tipoOcorrencia.OU}");  // Outro
	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private TipoOcorrencia(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
