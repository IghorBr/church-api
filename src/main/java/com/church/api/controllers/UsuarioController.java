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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.church.api.domain.BaseController;
import com.church.api.dtos.UsuarioDTO;
import com.church.api.entities.Usuario;
import com.church.api.repositories.UsuarioRepository;
import com.church.api.services.UsuarioService;
import com.church.api.services.exceptions.ObjectNotFoundException;
import com.querydsl.core.types.Predicate;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController extends BaseController<Usuario, UsuarioDTO> {

	public UsuarioController() {
		super(Usuario.class, UsuarioDTO.class);
	}

	@Autowired private UsuarioService usuarioService;

	@GetMapping(value = "/pesquisar")
	public ResponseEntity<List<UsuarioDTO>> pesquisar(
			@QuerydslPredicate(root = Usuario.class, bindings = UsuarioRepository.class) Predicate predicate) {
		
		List<Usuario> usuarios = usuarioService.pesquisar(predicate);
		return ResponseEntity.ok().body(super.mapList(usuarios));
	}
	
	@PostMapping
	public ResponseEntity<Void> saveUsuario(@RequestBody @Valid UsuarioDTO dto) {
		Usuario usuario = mapper.map(dto, Usuario.class);
		
		usuario = usuarioService.save(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> updateById(
			@PathVariable Long id,
			@RequestBody @Valid UsuarioDTO dto) {
		
		Usuario oldObj = usuarioService.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
		Usuario usuario = mapper.map(dto, Usuario.class);
		usuario.setId(id);
		usuario.getTemplosFavoritos().addAll(oldObj.getTemplosFavoritos());
		
		usuario = usuarioService.updateById(usuario, id);
		
		return ResponseEntity.noContent().build();
	}
}



















