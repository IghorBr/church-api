package com.church.api.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Congregacao extends Templo {

	@ManyToOne
	@JoinColumn(name = "igreja_id")
	private Igreja igrejaMatriz;
	
	public Congregacao(Long id, String nomeCompleto, String nomeCurto, Date dataInauguracao, String telefone,
			Endereco endereco, Igreja igrejaMatriz) {
		super(id, nomeCompleto, nomeCurto, dataInauguracao, telefone, endereco);
		this.igrejaMatriz = igrejaMatriz;
	}

	public Congregacao(Long id, String nomeCompleto, String nomeCurto, Date dataInauguracao, String telefone,
			Endereco endereco) {
		super(id, nomeCompleto, nomeCurto, dataInauguracao, telefone, endereco);
	}
}
