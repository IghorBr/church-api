package com.church.api.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Igreja extends Templo {

	private String cnpj;
	
	@OneToMany(mappedBy = "igrejaMatriz")
	@Setter(value = AccessLevel.NONE)
	private List<Congregacao> congregacoes = new ArrayList<Congregacao>();
	
	@OneToOne
	@JoinColumn(name = "pastor_id", referencedColumnName = "id")
	private Pastor pastorPresidente;
	
	public Igreja(Long id, String nomeCompleto, String nomeCurto, Date dataInauguracao, String telefone,
			Endereco endereco, String cnpj) {
		super(id, nomeCompleto, nomeCurto, dataInauguracao, telefone, endereco);
		this.cnpj = cnpj;
	}
	
	public void addCongregacao(Congregacao... congregacoes) {
		for (Congregacao c : congregacoes) 
			this.congregacoes.add(c);
	}
}
