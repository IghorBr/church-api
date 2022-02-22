package com.church.api.dtos;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RecorrenciaDTO extends BaseDTO {
	private static final long serialVersionUID = -2126310743281876272L;
	
	@NotEmpty private String diaDaSemana;
	@NotEmpty private String tipoRecorrencia;
	@NotEmpty private String horaEvento;
}
