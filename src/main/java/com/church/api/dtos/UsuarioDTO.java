package com.church.api.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioDTO extends BaseDTO {
	private static final long serialVersionUID = -1203414995568838135L;
	
	@NotEmpty private String nome;
	@NotEmpty private String sobrenome;
	@NotEmpty @Email private String email;
	@NotEmpty private String senha;
	@NotEmpty private String tipoUsuario;
}
