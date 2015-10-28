/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.filter;

import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import javax.enterprise.context.Dependent;
import javax.servlet.FilterChain;
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
@WebFilter("*.xhtml")
public class FiltroAutorizacao implements Filter {

    public FiltroAutorizacao() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession sessao = req.getSession();
        Boolean logado = (Boolean) sessao.getAttribute("logado");
        logado = logado == null ? false : logado;
        if (!logado) {
             String contextPath = ((HttpServletRequest)request).getContextPath();
            ((HttpServletResponse)response).sendRedirect(contextPath);
        } 
        chain.doFilter(request, response);
    }

    @Override
    public boolean isLoggable(LogRecord lr) {
        return false;
    }
}
