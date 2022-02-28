package com.church.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.church.api.domain.BaseController;
import com.church.api.dtos.UsuarioDTO;
import com.church.api.entities.Usuario;
import com.church.api.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController extends BaseController<Usuario, UsuarioDTO> {

	public UsuarioController() {
		super(Usuario.class, UsuarioDTO.class);
	}

	@Autowired private UsuarioService usuarioService;

	
}



















