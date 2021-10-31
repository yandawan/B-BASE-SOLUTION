package com.example.demo;

import brave.propagation.ExtraFieldPropagation;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

// todo Consumer 步骤2：封装包裹
@Component
public class MyTraceFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1. 从 request 中取出 header
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String baggageId = request.getHeader("BaggageId");

        // 2. 封装包裹
        ExtraFieldPropagation.set("BaggageId", baggageId);

        filterChain.doFilter(servletRequest,servletResponse);
    }


}