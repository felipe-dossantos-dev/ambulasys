/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.filter;

import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author felipe
 */
//@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class FiltroAutorizacao implements Filter {
 
    public FiltroAutorizacao() {
    }
 
    public void init(FilterConfig filterConfig) throws ServletException {
 
    }
 
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {
 
            HttpServletRequest reqt = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession ses = reqt.getSession(false);
 
            String reqURI = reqt.getRequestURI();
            if (reqURI.indexOf("/login.xhtml") >= 0
                    || (ses != null && ses.getAttribute("user") != null)
                    || reqURI.indexOf("/public/") >= 0
                    || reqURI.contains("javax.faces.resource")){
                chain.doFilter(request, response);
                System.out.println("Enttrou!");
            }
            else
                resp.sendRedirect(reqt.getContextPath() + "/faces/login.xhtml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
 
    public void destroy() {
 
    }

    @Override
    public boolean isLoggable(LogRecord lr) {
        return false;
    }
}
