package com.church.api.entities;

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
}
