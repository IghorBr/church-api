package com.church.api.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.api.domain.BaseServiceImpl;
import com.church.api.entities.Pastor;
import com.church.api.repositories.PastorRepository;
import com.church.api.services.PastorService;
import com.querydsl.core.types.Predicate;

@Service
public class PastorServiceImpl extends BaseServiceImpl<Pastor> implements PastorService {

	@Autowired private PastorRepository pastorRepository;

	@Override
	public List<Pastor> pesquisar(Predicate predicate) {
		List<Pastor> pastores = new ArrayList<Pastor>();
		pastorRepository.findAll(predicate).forEach(pastores::add);
		return pastores;
	}

}
