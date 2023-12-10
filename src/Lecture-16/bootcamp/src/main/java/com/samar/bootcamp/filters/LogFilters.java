package com.samar.bootcamp.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LogFilters implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("entering log-filter " + servletRequest);
        // without this line, request will not go pass filters
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("exiting log-filter " + servletRequest);
    }
}
