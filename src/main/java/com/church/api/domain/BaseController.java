package com.church.api.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.church.api.services.exceptions.ObjectNotFoundException;

public abstract class BaseController<T extends BaseDomain, K extends BaseDTO> {

	@Autowired private BaseService<T> baseService;
	private ModelMapper mapper = new ModelMapper();
	
	@GetMapping(value = "/")
	public ResponseEntity<List<BaseDTO>> findAll() {
		List<BaseDTO> dtos = baseService.findAll()
						.stream()
						.map(e -> mapper.map(e, BaseDTO.class))
						.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(dtos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BaseDTO> findById(@PathVariable Long id) {
		Optional<T> opt = baseService.findById(id);
		
		if (opt.isEmpty())
			throw new ObjectNotFoundException("Objeto não encontrado!");
		
		BaseDTO dto = mapper.map(opt.get(), BaseDTO.class);
		return ResponseEntity.ok().body(dto);
	}
	
}
