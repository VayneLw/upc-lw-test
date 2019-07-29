package com.upc;

import com.upc.script.ExpressionBaseScript;
import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.Script;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.runtime.InvokerHelper;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by liwei on 2019/7/26
 */
public class ExpressionEngine {
    private final GroovyClassLoader loader;
    private CompilerConfiguration runtimeConfig;

    public ExpressionEngine() {
        this.runtimeConfig = new CompilerConfiguration();
        this.setScriptBaseClass(runtimeConfig);
        this.loader = new GroovyClassLoader(GroovyClassLoader.class.getClassLoader(), runtimeConfig);
    }

    public Object evaluate(String expression, Map<String, Object> bindings) {
        Class<?> parseClass = this.parseClass(expression);
        Binding binding = this.createBinding(bindings);
        Script script = InvokerHelper.createScript(parseClass, binding);
        return script.run();
    }

    private Class<?> parseClass(String expression) {
        return this.loader.parseClass(expression);
    }

    private Binding createBinding(Map<String, Object> bindings) {
        Binding binding = new Binding();
        if (bindings != null) {
            Iterator var4 = bindings.entrySet().iterator();

            while (true) {
                while (var4.hasNext()) {
                    Map.Entry<String, Object> entry = (Map.Entry) var4.next();
                    if (!(entry.getValue() instanceof Double) && !(entry.getValue() instanceof Float)) {
                        binding.setVariable((String) entry.getKey(), entry.getValue());
                    } else {
                        Number value = (Number) entry.getValue();
                        binding.setVariable((String) entry.getKey(), BigDecimal.valueOf(value.doubleValue()));
                    }
                }

                return binding;
            }
        } else {
            return binding;
        }
    }

    private void setScriptBaseClass(CompilerConfiguration config) {
        config.setScriptBaseClass(ExpressionBaseScript.class.getCanonicalName());
    }
}
