package com.church.api.repositories;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

import com.church.api.domain.BaseRepository;
import com.church.api.entities.QTemplo;
import com.church.api.entities.Templo;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import lombok.NonNull;

@Repository
public interface TemploRepository extends BaseRepository<Templo>, QuerydslPredicateExecutor<Templo>, QuerydslBinderCustomizer<QTemplo>{

	@Override
	default void customize(@NonNull QuerydslBindings bindings, @NonNull QTemplo entity) {
		bindings.bind(String.class)
				.first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
	}
}
