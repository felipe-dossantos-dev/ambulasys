/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.repository;

import br.fipp.ambulasys.model.Pessoa;
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
public class Pessoas extends RepositorioGenerico<Pessoa, Integer>{
    public Pessoas() {
        super(Pessoa.class);
    }
    
    public boolean validar(String login, String senha) {
        Query createQuery = manager.createQuery("select p from Pessoa p where (p.login = :login and p.senha = :senha)");
        createQuery.setParameter("login", login);
        createQuery.setParameter("senha", senha);
        List<Pessoa> lista = createQuery.getResultList();
        return lista.size() == 1;
    }

    public List<Pessoa> findByHospital(Integer hospitalId) {
        Query createQuery = manager.createQuery("select v from Pessoa v where v.hospitalId.id = :hospital");
        createQuery.setParameter("hospital", hospitalId);
        return createQuery.getResultList();
    }

    public List<Pessoa> findByMotoristaHospital(Integer hospitalId) {
        Query createQuery = manager.createQuery("select v from Pessoa v where v.hospitalId.id = :hospital and v.perfilId.id = 2");
        createQuery.setParameter("hospital", hospitalId);
        return createQuery.getResultList();
    }
}
