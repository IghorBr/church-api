package com.church.api.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
	
	@ManyToMany
	@JoinTable(
		name="PASTOR_IGREJA",
		joinColumns = @JoinColumn(name="igreja_id"),
		inverseJoinColumns = @JoinColumn(name="pastor_id")
	)
	private List<Pastor> pastores = new ArrayList<Pastor>();
}
