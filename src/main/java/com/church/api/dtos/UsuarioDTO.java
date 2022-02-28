package com.church.api.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.church.api.domain.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UsuarioDTO extends BaseDTO {
	private static final long serialVersionUID = -1203414995568838135L;
	
	@NotEmpty private String nome;
	@NotEmpty private String sobrenome;
	@NotEmpty @Email private String email;
	@NotEmpty private String senha;
	@NotEmpty private String tipoUsuario;
}
