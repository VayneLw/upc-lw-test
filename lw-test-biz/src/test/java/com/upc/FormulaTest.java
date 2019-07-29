package com.upc;

import com.google.common.collect.Maps;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by liwei on 2019/7/23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-test.xml")
public class FormulaTest {

    @Autowired
    private ExpressionService expressionService;

    @Test
    public void test1(){
        String expression = "f1*f2/2+100";
        Map<String, Object> param = Maps.newHashMap();
        param.put("f1",100);
        param.put("f2",21);
        Object evaluate = expressionService.evaluate(expression, param);
        System.out.println(evaluate);
    }

    @Test
    public void test2(){
        String expression = "MAX(f1,f2)";
        Map<String, Object> param = Maps.newHashMap();
        param.put("f1",100);
        param.put("f2",21);
        Object evaluate = expressionService.evaluate(expression, param);
        System.out.println(evaluate);
    }
}
