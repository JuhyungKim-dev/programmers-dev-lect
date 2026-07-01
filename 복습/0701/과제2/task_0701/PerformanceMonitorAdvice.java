package com.example.spring.springtheory.ch06.task_0701;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceMonitorAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String name = invocation.getMethod().getDeclaringClass().getSimpleName() + "." + invocation.getMethod().getName();
        long start = System.nanoTime();
        try {
            return invocation.proceed();
        } finally {
            long end = System.nanoTime();
            System.out.println("[PERF] " + name + " : " + (end - start) / 1_000_000 + "ms");
        }
    }
}
