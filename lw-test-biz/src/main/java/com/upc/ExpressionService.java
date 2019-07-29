package com.upc;

import java.util.Map;

/**
 * Created by liwei on 2019/7/26
 */
public interface ExpressionService {
    Object evaluate(String var1, Map<String, Object> var2);
}
