package com.church.api.services;

import java.util.List;

import com.church.api.domain.BaseService;
import com.church.api.entities.Usuario;
import com.querydsl.core.types.Predicate;

public interface UsuarioService extends BaseService<Usuario> {

	List<Usuario> pesquisar(Predicate predicate);

}
