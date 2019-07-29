package com.upc.functions;

import groovy.transform.Trait;
import org.codehaus.groovy.transform.trait.Traits;

import java.math.BigDecimal;

/**
 * Created by liwei on 2019/7/26
 */
@Trait
public interface MathFunction {
    @Traits.Implemented
    double MAX(double var1, double var3);

    @Traits.Implemented
    BigDecimal MAX(BigDecimal var1, BigDecimal var2);
}
