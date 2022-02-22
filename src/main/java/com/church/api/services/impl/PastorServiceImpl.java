package com.church.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.api.domain.BaseServiceImpl;
import com.church.api.entities.Pastor;
import com.church.api.repositories.PastorRepository;
import com.church.api.services.PastorService;

@Service
public class PastorServiceImpl extends BaseServiceImpl<Pastor> implements PastorService {

	@Autowired private PastorRepository pastorRepository;
}
