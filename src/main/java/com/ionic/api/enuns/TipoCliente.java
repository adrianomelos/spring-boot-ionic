package com.ionic.api.enuns;

public enum TipoCliente {

	PF(0),
	PJ(1);

	private int cod;
	
	private TipoCliente(int i) {
		this.cod = i;
	}

	public int getCod() {
		return cod;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoCliente t : TipoCliente.values()) {
			if(cod.equals(t.getCod())) {
				return t;
			}
		}
		
		throw new IllegalArgumentException("id inválido" + cod);
	}
}
