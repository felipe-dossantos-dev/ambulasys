/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.repository;

import br.fipp.ambulasys.model.Cidade;
import br.fipp.ambulasys.model.Hospital;
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
public class Hospitais extends RepositorioGenerico<Hospital, Integer> {

    public Hospitais() {
        super(Hospital.class);
    }
    
    public List<Hospital> findByCidade(Integer cidade) {
        Query query = manager.createQuery("select h from Hospital where cidade_id = :cidade");
        query.setParameter("cidade", cidade);
        return query.getResultList();
    }
}
