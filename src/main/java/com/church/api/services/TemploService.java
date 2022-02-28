package com.church.api.services;

import java.util.List;

import com.church.api.domain.BaseService;
import com.church.api.entities.Templo;
import com.querydsl.core.types.Predicate;

public interface TemploService extends BaseService<Templo> {

	List<Templo> pesquisar(Predicate predicate);

}
