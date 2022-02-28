package com.church.api.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.church.api.domain.BaseDomain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Pastor extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String sobrenome;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataPosse;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataSaida;
	
	public Pastor(Long id, String nome, String sobrenome, Date dataPosse, Date dataSaida) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataPosse = dataPosse;
		this.dataSaida = dataSaida;
	}
	
}
