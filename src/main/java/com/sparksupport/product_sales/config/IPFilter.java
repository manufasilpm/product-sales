package com.sparksupport.product_sales.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class IPFilter implements Filter {

    @Value("${app.allowed.ips}")
    private String allowedIps;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String clientIp = request.getRemoteAddr();
        List<String> allowedList = Arrays.asList(allowedIps.split(","));

        log.info("Request from IP: {}", clientIp);

        if (allowedList.contains(clientIp)) {
            chain.doFilter(request, response);
        } else {
            log.warn("Blocked unauthorized IP: {}", clientIp);
            res.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied from IP: " + clientIp);
        }
    }


}