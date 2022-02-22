package com.church.api.entities.enums;

import lombok.Getter;

public enum TipoRecorrencia {

	DIARIA("Diário"),
	SEMANAL("Semanal"),
	MENSAL("Mensal"),
	ANUAL("Anual");
	
	@Getter
	private String descricao;
	
	private TipoRecorrencia(String descricao) {
		this.descricao = descricao;
	}

	public static TipoRecorrencia getTipoRecorrenciaByDescricao(String descricao) {
		for (TipoRecorrencia d : TipoRecorrencia.values()) {
			if (d.getDescricao().equalsIgnoreCase(descricao))
				return d;
		}
		
		return null;
	}
}
