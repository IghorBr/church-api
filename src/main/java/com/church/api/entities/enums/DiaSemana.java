package com.church.api.entities.enums;

import lombok.Getter;

public enum DiaSemana {

	DOMINGO("Domingo"),
	SEGUNDA("Segunda-feira"),
	TERCA("Terça-feira"),
	QUARTA("Quarta-feira"),
	QUINTA("Quinta feira"),
	SEXTA("Sexta-feira"),
	SABADO("Sábado");
	
	@Getter
	private String descricao;
	
	private DiaSemana(String descricao) {
		this.descricao = descricao;
	}
	
	public static DiaSemana getDiaSemanaByDescricao(String descricao) {
		for (DiaSemana d : DiaSemana.values()) {
			if (d.getDescricao().equalsIgnoreCase(descricao))
				return d;
		}
		
		return null;
	}
}
