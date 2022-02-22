package com.church.api.dtos;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EventoDTO extends BaseDTO {
	private static final long serialVersionUID = 8956255713169730864L;
	
	@NotEmpty
	private String descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = JsonFormat.DEFAULT_TIMEZONE)
	private Date dataEvento;
	
	private RecorrenciaDTO recorrencia;

}
