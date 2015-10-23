/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.repository;

import br.fipp.ambulasys.model.Regiao;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author felipe
 */
//@Dependent
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Stateless
public class Regioes implements Serializable {

    private static final long serialVersionUID = 1L;

    // @Inject
    @PersistenceContext(unitName = "ambulasysPU") // responsabilidade do servidor glassfish
    private EntityManager manager;

    public Regiao guardar(Regiao regiao) {
        //manager.getTransaction().begin();
        regiao = manager.merge(regiao);
        //manager.getTransaction().commit();

        return regiao;
    }

    public List<Regiao> todos() {
        return manager.createQuery("from Regiao order by id desc",
                Regiao.class).getResultList();
    }

    public Regiao porId(Integer id) {
        return manager.find(Regiao.class, id);
    }

}
