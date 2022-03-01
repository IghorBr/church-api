package com.church.api.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.church.api.domain.BaseController;
import com.church.api.dtos.EventoDTO;
import com.church.api.dtos.TemploDTO;
import com.church.api.entities.Congregacao;
import com.church.api.entities.Evento;
import com.church.api.entities.Igreja;
import com.church.api.entities.Templo;
import com.church.api.repositories.TemploRepository;
import com.church.api.services.EventoService;
import com.church.api.services.TemploService;
import com.church.api.services.exceptions.ObjectNotFoundException;
import com.querydsl.core.types.Predicate;

@RestController
@RequestMapping(value = "/templos")
public class TemploController extends BaseController<Templo, TemploDTO> {

	public TemploController() {
		super(Templo.class, TemploDTO.class);
	}
	
	private final String NOT_FOUND_MESSAGE = "Templo não encontrado";

	@Autowired private TemploService temploService;
	@Autowired private EventoService eventoService;
	
	@GetMapping(value = "/pesquisar")
	public ResponseEntity<List<TemploDTO>> pesquisar(
			@QuerydslPredicate(root = Templo.class, bindings = TemploRepository.class) Predicate predicate) {
		
		List<Templo> templos = temploService.pesquisar(predicate);
		List<TemploDTO> dtos = templos.stream()
										.map(t -> mapper.map(t, TemploDTO.class))
										.collect(Collectors.toList());
		for (TemploDTO t : dtos) {
			t.setEventos(null);
		}
		
		return ResponseEntity.ok().body(dtos);
	}
	
	@GetMapping(value = "/eventos/{id}")
	public ResponseEntity<List<EventoDTO>> listEventoByTemplo(@PathVariable Long id,
			@RequestParam(name = "apenasRecorrentes", defaultValue = "false") boolean apenasRecorrentes) {
		List<Evento> eventos = eventoService.findAllEventosByTemplo(id, apenasRecorrentes);
		List<EventoDTO> dtos = eventos.stream().map(e -> mapper.map(e, EventoDTO.class)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(dtos);
	}
	
	@PostMapping	
	public ResponseEntity<Void> saveTemplo(
			@RequestParam(name = "isTemplo", required = true) boolean isTemplo,
			@RequestBody @Valid TemploDTO dto) {
		
		Templo templo = Templo.dtoToEntity(isTemplo, dto);
		
		templo = temploService.save(templo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(templo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> updateById(
			@PathVariable Long id,
			@RequestParam(name = "isTemplo", required = true) boolean isTemplo,
			@RequestBody @Valid TemploDTO dto) {
		
		Templo oldObj = temploService.findById(id).orElseThrow(() -> new ObjectNotFoundException(NOT_FOUND_MESSAGE));
		
		Templo templo = Templo.dtoToEntity(isTemplo, dto);
		templo.setId(id);
		templo.getEndereco().setId(oldObj.getEndereco().getId());
		if (templo instanceof Igreja) {
			((Igreja) templo).setPastorPresidente(((Igreja) oldObj).getPastorPresidente());
		} else {
			((Congregacao) templo).setIgrejaMatriz(((Congregacao) oldObj).getIgrejaMatriz());
		}
		templo = temploService.updateById(templo, id);
		
		return ResponseEntity.noContent().build();
	}
}











