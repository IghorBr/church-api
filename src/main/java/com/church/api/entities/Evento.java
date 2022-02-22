package com.church.api.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import com.church.api.domain.BaseDomain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Evento extends BaseDomain {
	
	@PrePersist
	private void prePersist() {
		this.dataCriacao = new Date();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	private Date dataEvento;
	private Date dataCriacao;
	
	@ManyToOne
	@JoinColumn(name = "templo_id")
	private Templo templo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="recorrencia_id")
	private Recorrencia recorrencia;
	
	public Evento(Long id, String descricao, Date dataEvento, Recorrencia recorrencia, Templo templo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataEvento = dataEvento;
		this.recorrencia = recorrencia;
		this.templo = templo;
	}
	
}
