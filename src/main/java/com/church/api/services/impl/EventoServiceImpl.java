package com.church.api.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.api.domain.BaseServiceImpl;
import com.church.api.entities.Evento;
import com.church.api.repositories.EventoRepository;
import com.church.api.services.EventoService;
import com.querydsl.core.types.Predicate;

@Service
public class EventoServiceImpl extends BaseServiceImpl<Evento> implements EventoService {

	@Autowired private EventoRepository eventoRepository;

	@Override
	public List<Evento> pesquisarEvento(Predicate predicate) {
		List<Evento> eventos = new ArrayList<Evento>();
		eventoRepository.findAll(predicate).forEach(eventos::add);
		
		return eventos;
	}
}
