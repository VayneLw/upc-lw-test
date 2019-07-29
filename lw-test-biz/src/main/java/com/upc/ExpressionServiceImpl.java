package com.upc;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by liwei on 2019/7/26
 */
@Service
public class ExpressionServiceImpl implements ExpressionService {
    private ExpressionEngine expressionEngine = new ExpressionEngine();

    @Override
    public Object evaluate(String expression, Map<String, Object> bindings) {
        return this.expressionEngine.evaluate(expression, bindings);
    }
}
