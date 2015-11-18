/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.controller;

import br.fipp.ambulasys.model.Notificacao;
import br.fipp.ambulasys.repository.Notificacoes;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author felipe.santos
 */
@ManagedBean
@ApplicationScoped
public class NotificacaoController {
    @EJB
    private Notificacoes notificacoes;
    
    private List<Notificacao> listaNotificacao;
    
    @PostConstruct
    public void init() {
        listaNotificacao = notificacoes.findAll();
    }
}
