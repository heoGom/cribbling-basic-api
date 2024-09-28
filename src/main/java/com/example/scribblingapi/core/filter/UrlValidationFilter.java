package com.example.scribblingapi.core.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlValidationFilter implements Filter {

    private static final Pattern VALID_URL_PATTERN = Pattern.compile("^[a-zA-Z0-9?&=/:]*$");


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        Matcher matcher = VALID_URL_PATTERN.matcher(uri);

        if (!matcher.find()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("<h1>Invalid URL</h1>");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
