package com.church.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.church.api.domain.BaseController;
import com.church.api.dtos.TemploDTO;
import com.church.api.entities.Templo;
import com.church.api.repositories.TemploRepository;
import com.church.api.services.TemploService;
import com.querydsl.core.types.Predicate;

@RestController
@RequestMapping(value = "/templos")
public class TemploController extends BaseController<Templo, TemploDTO> {

	public TemploController() {
		super(Templo.class, TemploDTO.class);
	}

	@Autowired private TemploService temploService;
	
	@GetMapping(value = "/pesquisar")
	public ResponseEntity<List<TemploDTO>> pesquisar(
			@QuerydslPredicate(root = Templo.class, bindings = TemploRepository.class) Predicate predicate) {
		
		List<Templo> templos = temploService.pesquisar(predicate);
		return ResponseEntity.ok().body(super.mapList(templos));
	}
}
