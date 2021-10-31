package com.example.demo;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyUrlBlockHandler implements UrlBlockHandler {
    @Override
    public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws IOException {
        // 1. 根据不同的异常类型，定义不同的错误信息
        String errmsg = "";
        if(e instanceof FlowException){
            errmsg = "限流";
        }else if(e instanceof DegradeException){
            errmsg = "降级";
        }else if(e instanceof ParamFlowException){
            errmsg = "热点参数";
        }else if(e instanceof SystemBlockException){
            errmsg = "系统规则";
        }else if(e instanceof AuthorityException){
            errmsg = "授权规则";
        }

        // 2. 输出错误信息
        httpServletResponse.setStatus(500);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        new ObjectMapper().writeValue(
                httpServletResponse.getWriter(), errmsg
        );
    }
}
