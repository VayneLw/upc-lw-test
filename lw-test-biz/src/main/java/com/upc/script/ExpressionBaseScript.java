package com.upc.script;

import com.upc.functions.MathFunction;
import groovy.lang.Script;

import java.math.BigDecimal;

/**
 * Created by liwei on 2019/7/26
 */
public abstract class  ExpressionBaseScript extends Script implements MathFunction {
    @Override
    public double MAX(double p1, double p2) {
        return Math.max(p1,p2);
    }

    @Override
    public BigDecimal MAX(BigDecimal var1, BigDecimal var2) {
        return null;
    }
}
