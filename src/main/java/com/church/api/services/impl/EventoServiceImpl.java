package com.church.api.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.api.domain.BaseServiceImpl;
import com.church.api.entities.Evento;
import com.church.api.entities.QEvento;
import com.church.api.repositories.EventoRepository;
import com.church.api.services.EventoService;
import com.church.api.utils.DateUtil;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

@Service
public class EventoServiceImpl extends BaseServiceImpl<Evento> implements EventoService {

	@Autowired private EventoRepository eventoRepository;

	@Override
	public List<Evento> pesquisarEvento(Predicate predicate) {
		List<Evento> eventos = new ArrayList<Evento>();
		eventoRepository.findAll(predicate).forEach(eventos::add);
		
		Date first = DateUtil.getFirstDayOfYear();
		Date last = DateUtil.getLastDayOfYear();
		
		for (Evento e : eventos) {
			if (e.getDataCriacao().before(first) || e.getDataCriacao().after(last))
				eventos.remove(e);
		}
		
		return eventos;
	}

	@Override
	public List<Evento> findAllEventosByTemplo(Long id, boolean apenasRecorrentes) {
		JPAQuery<Evento> query = new JPAQuery<Evento>(entityManager);
		QEvento eventoQuery = QEvento.evento;
		
		Date first = DateUtil.getFirstDayOfYear();
		Date last = DateUtil.getLastDayOfYear();
		
		query = query.from(eventoQuery)
					.where(
						eventoQuery.templo.id.eq(id),
						eventoQuery.dataCriacao.between(first, last)
					);
		
		if (apenasRecorrentes) 
			query.where(eventoQuery.recorrencia.isNotNull());
		
		return query.fetch();
	}
}
