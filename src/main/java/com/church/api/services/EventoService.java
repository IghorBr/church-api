package com.church.api.services;

import java.util.List;

import com.church.api.domain.BaseService;
import com.church.api.entities.Evento;
import com.querydsl.core.types.Predicate;

public interface EventoService extends BaseService<Evento> {

	List<Evento> pesquisarEvento(Predicate predicate);
	List<Evento> findAllEventosByTemplo(Long id, boolean apenasRecorrentes);

}
