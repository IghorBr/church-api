package com.church.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.api.domain.BaseServiceImpl;
import com.church.api.entities.Evento;
import com.church.api.repositories.EventoRepository;
import com.church.api.services.EventoService;

@Service
public class EventoServiceImpl extends BaseServiceImpl<Evento> implements EventoService {

	@Autowired private EventoRepository eventoRepository;
}
