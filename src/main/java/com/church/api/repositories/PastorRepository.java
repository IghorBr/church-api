package com.church.api.repositories;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

import com.church.api.domain.BaseRepository;
import com.church.api.entities.Pastor;
import com.church.api.entities.QPastor;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import lombok.NonNull;

@Repository
public interface PastorRepository extends BaseRepository<Pastor>, QuerydslPredicateExecutor<Pastor>, QuerydslBinderCustomizer<QPastor> {
	
	@Override
	default void customize(@NonNull QuerydslBindings bindings, @NonNull QPastor entity) {
		bindings.bind(String.class)
				.first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
	}
}