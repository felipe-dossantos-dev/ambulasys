/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.repository;

import br.fipp.ambulasys.model.Notificacao;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;

/**
 *
 * @author felipe
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Stateless
public class Notificacoes extends RepositorioGenerico<Notificacao, Integer>{

    public Notificacoes() {
        super(Notificacao.class);
    }
    
    public List<Notificacao> findByHospital(Integer hospitalId) {
        Query q = manager.createQuery("select n from Notificacao n where"
                + " n.hospitalId.id = :id");
        q.setParameter("id", hospitalId);
        return q.getResultList();
    }
    
    public List<Object> countNotSeen(Integer hospitalId) {
        Query q = manager.createQuery("select count(n.id) from Notificacao n where"
                + " n.hospitalId.id = :id and n.visto = FALSE");
        q.setParameter("id", hospitalId);
        return q.getResultList();
    }
}
