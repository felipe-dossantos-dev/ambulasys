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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author felipe.santos
 */
@ManagedBean
@SessionScoped
public class NotificacaoGeralController {
    
    @EJB
    private Notificacoes notificacoes;
    
    private List<Notificacao> listaNotificacao;
    private Integer hospitalId;
    private Long notificacaoNaoVista;
    
    @PostConstruct
    public void init() {
        hospitalId = (Integer) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("hospitalId");
        listaNotificacao = notificacoes.findByHospital(hospitalId);
        notificacaoNaoVista = (Long) notificacoes.countNotSeen(hospitalId).get(0);
    }

    public List<Notificacao> getListaNotificacao() {
        return listaNotificacao;
    }

    public void setListaNotificacao(List<Notificacao> listaNotificacao) {
        this.listaNotificacao = listaNotificacao;
    }
    
    public void vistarTodos() {
        for (Notificacao not : listaNotificacao) {
            not.setVisto(true);
            notificacoes.save(not);
        }
    }

    public Long getNotificacaoNaoVista() {
        notificacaoNaoVista = (Long) notificacoes.countNotSeen(hospitalId).get(0);
        return notificacaoNaoVista;
    }

    public void setNotificacaoNaoVista(Long notificacaoNaoVista) {
        this.notificacaoNaoVista = notificacaoNaoVista;
    }
}
