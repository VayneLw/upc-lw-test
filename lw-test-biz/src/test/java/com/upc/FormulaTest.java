package com.upc;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.junit.Test;

/**
 * Created by liwei on 2019/7/23
 */
public class FormulaTest {

    @Test
    public void test1(){
        GroovyShell shell = new GroovyShell();
        Object result = shell.evaluate("1+2/2");
        System.out.println(result);
    }

    @Test
    public void test2(){
        Binding param = new Binding();
        param.setVariable("f1",101.2);
        param.setVariable("f2",101.2);
        GroovyShell shell = new GroovyShell(param);
        Object result = shell.evaluate("f1+f2*2");
        System.out.println(result);
    }
}
