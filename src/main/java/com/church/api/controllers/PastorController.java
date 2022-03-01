package com.church.api.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.church.api.domain.BaseController;
import com.church.api.dtos.PastorDTO;
import com.church.api.entities.Pastor;
import com.church.api.repositories.PastorRepository;
import com.church.api.services.PastorService;
import com.church.api.services.exceptions.ObjectNotFoundException;
import com.querydsl.core.types.Predicate;

@RestController
@RequestMapping(value = "/pastores")
public class PastorController extends BaseController<Pastor, PastorDTO> {

	public PastorController() {
		super(Pastor.class, PastorDTO.class);
	}
	
	@Autowired private PastorService pastorService;
	
	@GetMapping("/pesquisar")
	public ResponseEntity<List<PastorDTO>> pesquisar(
			@QuerydslPredicate(root = Pastor.class, bindings = PastorRepository.class) Predicate predicate) {
		
		List<Pastor> entities = pastorService.pesquisar(predicate);
		return ResponseEntity.ok().body(super.mapList(entities));
	}
	
	@PostMapping
	public ResponseEntity<Void> savePastor(@RequestBody @Valid PastorDTO dto) {
		Pastor pastor = mapper.map(dto, Pastor.class);
		pastor = pastorService.save(pastor);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(pastor.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	public ResponseEntity<Void> updateById(
			@PathVariable Long id,
			@RequestBody @Valid PastorDTO dto) {

		Pastor oldObj = pastorService.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		Pastor pastor = mapper.map(dto, Pastor.class);
		
		pastor.setId(id);
		pastor.setIgreja(oldObj.getIgreja());
		
		pastor = pastorService.updateById(pastor, id);
		
		return ResponseEntity.noContent().build();
	}
}
