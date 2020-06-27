package com.dylan.xinyidai05.domain.common.validation.check;

import com.dylan.xinyidai05.domain.common.validation.constraints.Money;
import com.sun.org.apache.xerces.internal.impl.dtd.models.ContentModelValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/27 20:35
 */
public class MoneyCheck implements ConstraintValidator<Money,BigDecimal> {
	@Override
	public void initialize(Money constraintAnnotation) {

	}

	@Override
	public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
		return false;
	}
}
