package com.church.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EnderecoDTO extends BaseDTO {
	private static final long serialVersionUID = -7986071613047927188L;
	
	private String logradouro;
	private String uf;
	private String municipio;
	private String cep;
	private String numero;
	private String bairro;
}
