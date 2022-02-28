package com.church.api.dtos;

import javax.validation.constraints.NotEmpty;

import com.church.api.domain.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class RecorrenciaDTO extends BaseDTO {
	private static final long serialVersionUID = -2126310743281876272L;
	
	@NotEmpty private String diaDaSemana;
	@NotEmpty private String tipoRecorrencia;
	@NotEmpty private String horaEvento;
}
