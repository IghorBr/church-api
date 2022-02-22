package com.church.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.api.domain.BaseServiceImpl;
import com.church.api.entities.Usuario;
import com.church.api.repositories.UsuarioRepository;
import com.church.api.services.UsuarioService;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario> implements UsuarioService {

	@Autowired private UsuarioRepository usuarioRepository;
}
