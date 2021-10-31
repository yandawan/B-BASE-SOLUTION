package com.example.demo;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

public class ExceptionUtil {
    public static SentinelClientHttpResponse handleBlock(
            HttpRequest request,
            byte[] body,
            ClientHttpRequestExecution execution,
            BlockException ex
    ){
        System.out.println("handleblock ex class: " + ex.getClass().getCanonicalName());
        return new SentinelClientHttpResponse("my block info");
    }

    public static SentinelClientHttpResponse handleFallback(
            HttpRequest request,
            byte[] body,
            ClientHttpRequestExecution execution,
            BlockException ex
    ){
        System.out.println("handle fallback ex class: " + ex.getClass().getCanonicalName());
        return new SentinelClientHttpResponse("my fallback info");
    }
}
