package com.church.api.services;

import java.util.List;

import com.church.api.domain.BaseService;
import com.church.api.entities.Pastor;
import com.querydsl.core.types.Predicate;

public interface PastorService extends BaseService<Pastor> {

	public List<Pastor> pesquisar(Predicate predicate);
}
