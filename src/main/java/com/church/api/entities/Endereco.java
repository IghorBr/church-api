package com.church.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.church.api.domain.BaseDomain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Endereco extends BaseDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String logradouro;
	private String uf;
	private String municipio;
	private String cep;
	private String numero;
	private String bairro;
	
	@OneToOne(mappedBy = "endereco")
	private Templo templo;

	public Endereco(Long id, String logradouro, String uf, String municipio, String cep, String numero, String bairro) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.uf = uf;
		this.municipio = municipio;
		this.cep = cep;
		this.numero = numero;
		this.bairro = bairro;
	}
}
