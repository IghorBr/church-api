package com.church.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.church.api.domain.BaseController;
import com.church.api.dtos.EventoDTO;
import com.church.api.entities.Evento;
import com.church.api.repositories.EventoRepository;
import com.church.api.services.EventoService;
import com.querydsl.core.types.Predicate;

@RestController
@RequestMapping(value = "/eventos")
public class EventoController extends BaseController<Evento, EventoDTO> {

	public EventoController() {
		super(Evento.class, EventoDTO.class);
	}

	@Autowired private EventoService eventoService;
	
	@GetMapping(value = "/pesquisar")
	public ResponseEntity<List<EventoDTO>> pesquisar(
			@QuerydslPredicate(root = Evento.class, bindings = EventoRepository.class) Predicate predicate) {
		
		List<Evento> eventos = eventoService.pesquisarEvento(predicate);
		return ResponseEntity.ok().body(super.mapList(eventos));
	}
}