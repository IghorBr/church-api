package com.church.api.dtos;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TemploDTO extends BaseDTO {
	private static final long serialVersionUID = -2119409870148023145L;
	
	@NotEmpty
	private String nomeCompleto;
	private String nomeCurto;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = JsonFormat.DEFAULT_TIMEZONE)
	private Date dataInauguracao;
	private String telefone;
	
	@NotNull private EnderecoDTO endereco;
	private String cnpj;

}
