/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author felipe
 */
@WebFilter(filterName = "AutorizacaoFiltro", urlPatterns = {"/restrito/*"})
public class AutorizacaoFiltro implements Filter {

    
    public AutorizacaoFiltro() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession sessao = req.getSession();
        Boolean logado = (Boolean) sessao.getAttribute("logado");
        if (logado == null || !logado) {
            RequestDispatcher rd = request.getRequestDispatcher("/login.xhtml");
            rd.forward(request, response);
            return;
        } 
        try {
            if (chain != null && request != null && response != null) {
                req.getSession().setMaxInactiveInterval(1000); //1000 16 minutos, 30 minutos  1800, 40 minutos 2400
                chain.doFilter(request, response);
            }
        } catch (IOException | ServletException t) {
            System.out.println(t.getMessage());
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
