package com.church.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.api.domain.BaseServiceImpl;
import com.church.api.entities.Templo;
import com.church.api.repositories.TemploRepository;
import com.church.api.services.TemploService;

@Service
public class TemploServiceImpl extends BaseServiceImpl<Templo> implements TemploService {

	@Autowired private TemploRepository temploRepository;
}
