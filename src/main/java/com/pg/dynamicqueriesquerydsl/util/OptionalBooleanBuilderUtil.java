package com.pg.dynamicqueriesquerydsl.util;

import java.util.Collection;
import java.util.function.Function;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;

public class OptionalBooleanBuilderUtil {
	
	private BooleanExpression predicate;

    public OptionalBooleanBuilderUtil(BooleanExpression predicate) {
        this.predicate = predicate;
    }

    public <T> OptionalBooleanBuilderUtil notNullAnd(Function<T, BooleanExpression> expressionFunction, T value) {
        if (value != null) {
            return new OptionalBooleanBuilderUtil(predicate.and(expressionFunction.apply(value)));
        }
        return this;
    }

    public OptionalBooleanBuilderUtil notEmptyAnd(Function<String, BooleanExpression> expressionFunction, String value) {
        if (!StringUtils.isEmpty(value)) {
            return new OptionalBooleanBuilderUtil(predicate.and(expressionFunction.apply(value)));
        }
        return this;
    }

    public <T> OptionalBooleanBuilderUtil notEmptyAnd(Function<Collection<T>, BooleanExpression> expressionFunction, Collection<T> collection) {
        if (!CollectionUtils.isEmpty(collection)) {
            return new OptionalBooleanBuilderUtil(predicate.and(expressionFunction.apply(collection)));
        }
        return this;
    }

    public BooleanExpression build() {
        return predicate;
    }

}
