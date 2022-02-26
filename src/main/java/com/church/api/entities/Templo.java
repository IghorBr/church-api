package com.church.api.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.church.api.domain.BaseDomain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter
public abstract class Templo extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	private String nomeCompleto;
	private String nomeCurto;
	private Date dataInauguracao;
	private String telefone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "templo")
	@Setter(value = AccessLevel.NONE)
	private List<Evento> eventos = new ArrayList<Evento>();
	
	public Templo(Long id, String nomeCompleto, String nomeCurto, Date dataInauguracao, String telefone, Endereco endereco) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.nomeCurto = nomeCurto;
		this.dataInauguracao = dataInauguracao;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public void addEvento(Evento... eventos) {
		for (Evento e : eventos) 
			this.eventos.add(e);
	}
	
}
