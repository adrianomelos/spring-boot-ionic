package com.ionic.api.enuns;

public enum Perfil {

	ADMIN(0, "ROLE_ADMIN"),
	CLIENTE(1, "ROLE_CLIENTE");

	private int cod;
	private String perfil;
	
	private Perfil(int i, String perfil) {
		this.cod = i;
		this.perfil = perfil;
	}

	public int getCod() {
		return cod;
	}
	
	public static Perfil toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Perfil t : Perfil.values()) {
			if(cod.equals(t.getCod())) {
				return t;
			}
		}
		
		throw new IllegalArgumentException("id inválido" + cod);
	}

	public String getPerfil() {
		return perfil;
	}

}
