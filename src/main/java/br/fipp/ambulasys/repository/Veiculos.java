/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.repository;

import br.fipp.ambulasys.model.Veiculo;
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
public class Veiculos  extends RepositorioGenerico<Veiculo, Integer>{

    public Veiculos() {
        super(Veiculo.class);
    }
    
    public List<Veiculo> findByHospital(Integer hospitalId) {
        Query createQuery = manager.createQuery("select v from Veiculo v where v.hospitalId.id = :hospital");
        createQuery.setParameter("hospital", hospitalId);
        return createQuery.getResultList();
    }
}
