package com.church.api.entities.enums;

import lombok.Getter;

public enum TipoUsuario {

	CONVIDADO("Convidado"),
	MEMBRO("Membro"),
	ADMIN("Administrador");
	
	@Getter
	private String descricao;
	
	private TipoUsuario(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return this.getDescricao();
	}
	
	public static TipoUsuario getTipoUsuarioByDescricao(String descricao) {
		for (TipoUsuario t : TipoUsuario.values()) {
			if (t.getDescricao().equalsIgnoreCase(descricao))
				return t;
		}
		
		return null;
	}
}
