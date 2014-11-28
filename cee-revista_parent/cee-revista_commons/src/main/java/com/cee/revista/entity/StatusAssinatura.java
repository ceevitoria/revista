package com.cee.revista.entity;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum StatusAssinatura {
    
	A("{statusAssinatura.A}"),
	V("{statusAssinatura.V}"),
	C("{statusAssinatura.C}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private StatusAssinatura(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
