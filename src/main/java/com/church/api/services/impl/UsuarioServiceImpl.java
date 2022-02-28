package com.church.api.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.api.domain.BaseServiceImpl;
import com.church.api.entities.Usuario;
import com.church.api.repositories.UsuarioRepository;
import com.church.api.services.UsuarioService;
import com.querydsl.core.types.Predicate;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario> implements UsuarioService {

	@Autowired private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> pesquisar(Predicate predicate) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarioRepository.findAll(predicate).forEach(usuarios::add);
		
		return usuarios;
	}
}
