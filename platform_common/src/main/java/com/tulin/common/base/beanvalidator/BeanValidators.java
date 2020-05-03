package com.tulin.common.base.beanvalidator;

import com.google.common.collect.Lists;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


/**
 * hibernate-validator校验工具类
 *
 */
public class BeanValidators {
	
	/**
	 * 校验对象
	 * @param validator
	 * 
	 * @param object
	 *            待校验对象
	 * @param groups
	 *            待校验的组
	 * @return message
	 *            验证信息
	 * 				
	 */
	public static List<String> validateEntity(Validator validator, Object object, Class<?>... groups) throws Exception{
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
		if (!constraintViolations.isEmpty()) {
			List<String> list = Lists.newArrayList();
			Iterator<ConstraintViolation<Object>> iterator = constraintViolations.iterator();
			while (iterator.hasNext()) {
				String message = iterator.next().getMessage();
				list.add(message);
			}
			return list;
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		List<String> validateEntity = validateEntity(validator, null);
		System.out.println(validateEntity);
		
	}
}
