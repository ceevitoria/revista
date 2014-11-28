package com.cee.revista.entity;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoOcorrencia {
    
	EA("{tipoOcorrencia.EA}"),
	NR("{tipoOcorrencia.NR}"),
	RA("{tipoOcorrencia.RA}"),
	CA("{tipoOcorrencia.CA}"),
	OU("{tipoOcorrencia.OU}");

	
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
