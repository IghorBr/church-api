package com.church.api.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.church.api.domain.BaseDomain;
import com.church.api.entities.enums.DiaSemana;
import com.church.api.entities.enums.TipoRecorrencia;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Recorrencia extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private DiaSemana diaDaSemana;
	
	@Enumerated(EnumType.STRING)
	private TipoRecorrencia tipoRecorrencia;
	
	private String horaEvento;
	
	@OneToOne(mappedBy = "recorrencia")
	private Evento evento;
}
