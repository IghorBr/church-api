package com.church.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.church.api.domain.BaseController;
import com.church.api.dtos.UsuarioDTO;
import com.church.api.entities.Usuario;
import com.church.api.repositories.UsuarioRepository;
import com.church.api.services.UsuarioService;
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
}



















