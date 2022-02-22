package com.church.api.repositories;

import org.springframework.stereotype.Repository;

import com.church.api.domain.BaseRepository;
import com.church.api.entities.Pastor;

@Repository
public interface PastorRepository extends BaseRepository<Pastor> {

}
