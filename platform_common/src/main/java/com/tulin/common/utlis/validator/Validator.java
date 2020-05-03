package com.tulin.common.utlis.validator;//


import com.tulin.common.base.enumeration.ResponseCode;
import com.tulin.common.excption.BaseException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

public class Validator {
    public Validator() {
    }

    public static void notNull(String paramName, Object paramValue) {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        buf.append(StringUtils.isEmpty(paramName) ? "params" : paramName);
        buf.append("]");
        buf.append(" is required.");
        String errorMsg = buf.toString();
        if (paramValue == null) {
            throw new BaseException(ResponseCode.不允许为空, errorMsg);
        } else if (paramValue instanceof String && StringUtils.isEmpty((String) paramValue)) {
            throw new BaseException(ResponseCode.不允许为空, errorMsg);
        } else if (paramValue instanceof Collection && CollectionUtils.isEmpty((Collection) paramValue)) {
            throw new BaseException(ResponseCode.不允许为空, errorMsg);
        }
    }

}

