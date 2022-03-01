package com.church.api.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.church.api.services.exceptions.ObjectNotFoundException;

@RestController
public abstract class BaseController<T extends BaseDomain, K extends BaseDTO> {

	@Autowired private BaseService<T> baseService;
	protected ModelMapper mapper = new ModelMapper();
	private Class<T> entityTarget;
	private Class<K> dtoTarget;
	
	public BaseController(Class<T> entity, Class<K> dto) {
		this.entityTarget = entity;
		this.dtoTarget = dto;
	}

	@GetMapping(value = "")
	public ResponseEntity<List<K>> findAll() {
		List<T> entities = baseService.findAll();
		List<K> dtos = this.mapList(entities);
		
		return ResponseEntity.ok().body(dtos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<K> findById(@PathVariable Long id) {
		T entity = baseService.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		K dto = mapper.map(entity, dtoTarget);
		return ResponseEntity.ok().body(dto);
	}
		
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteEntity(@PathVariable Long id) {
		baseService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	protected List<K> mapList(List<T> source) {
	    return source
	    	      .stream()
	    	      .map(element -> mapper.map(element, dtoTarget))
	    	      .collect(Collectors.toList());
	}
	
}
