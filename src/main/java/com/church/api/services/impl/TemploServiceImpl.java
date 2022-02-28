package com.church.api.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.api.domain.BaseServiceImpl;
import com.church.api.entities.Templo;
import com.church.api.repositories.TemploRepository;
import com.church.api.services.TemploService;
import com.querydsl.core.types.Predicate;

@Service
public class TemploServiceImpl extends BaseServiceImpl<Templo> implements TemploService {

	@Autowired private TemploRepository temploRepository;

	@Override
	public List<Templo> pesquisar(Predicate predicate) {
		List<Templo> templos = new ArrayList<Templo>();
		temploRepository.findAll(predicate).forEach(templos::add);
		
		return templos;
	}
}
