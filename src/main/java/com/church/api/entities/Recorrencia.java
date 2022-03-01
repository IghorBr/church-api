package com.church.api.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import com.church.api.domain.BaseDomain;
import com.church.api.entities.enums.DiaSemana;
import com.church.api.entities.enums.TipoRecorrencia;
import com.church.api.services.exceptions.ChurchException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Recorrencia extends BaseDomain {
	
	@PrePersist
	private void prePersist() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		try {
			sdf.parse(horaEvento);
		} catch (ParseException e) {
			throw new ChurchException("A hora do evento é inválida!");
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private DiaSemana diaDaSemana;
	
	@Enumerated(EnumType.STRING)
	private TipoRecorrencia tipoRecorrencia;
	
	private String horaEvento;
	
	private Integer ocorreACada;
	
	@OneToOne(mappedBy = "recorrencia")
	private Evento evento;
}
