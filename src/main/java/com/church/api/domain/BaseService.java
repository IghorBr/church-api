package com.church.api.domain;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseDomain> {

	public abstract T save(T entity);
	public abstract List<T> saveAll(List<T> entities);

	public abstract List<T> findAll();
	public abstract Optional<T> findById(Long entityId);

	public abstract T updateById(T entity, Long entityId);
	
	public abstract void deleteById(Long entityId);
}
