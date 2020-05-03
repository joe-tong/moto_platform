package com.tulin.common.utlis.validator;


public interface ParamsValidator {
    default void notNull(String paramName, Object paramValue) {
        Validator.notNull(paramName, paramValue);
    }


}
