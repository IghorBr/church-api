package com.church.api.domain;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class BaseServiceImpl<T extends BaseDomain> implements BaseService<T> {

	@Autowired
	private BaseRepository<T> baseRepository;
	
	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	@Transactional
	public T save(T entity) {
		return (T) baseRepository.save(entity);
	}
	
	@Override
	@Transactional
	public List<T> saveAll(List<T> entities) {
		return (List<T>) baseRepository.saveAll(entities);
	}
	
	@Override
	@Transactional(readOnly = true)
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<T> findById(Long entityId) {
        return baseRepository.findById(entityId);
    }
	
	@Override
	@Transactional
	public T updateById(T entity, Long entityId) {
		Optional<T> optional = baseRepository.findById(entityId);
        if(optional.isPresent()){
            return (T) baseRepository.save(entity);
        }else{
            return null;
        }
	}

	@Override
	@Transactional
	public void deleteById(Long entityId) {
		baseRepository.deleteById(entityId);
	}
}
