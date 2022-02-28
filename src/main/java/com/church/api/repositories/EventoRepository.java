package com.church.api.repositories;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

import com.church.api.domain.BaseRepository;
import com.church.api.entities.Evento;
import com.church.api.entities.QEvento;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import lombok.NonNull;

@Repository
public interface EventoRepository extends BaseRepository<Evento>,
	QuerydslPredicateExecutor<Evento>, QuerydslBinderCustomizer<QEvento>{

	@Override
	default void customize(@NonNull QuerydslBindings bindings, @NonNull QEvento entity) {
		bindings.bind(String.class)
				.first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
	}
}
