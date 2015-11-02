/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.repository;

import br.fipp.ambulasys.model.Cidade;
import br.fipp.ambulasys.model.Uf;
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
public class Cidades extends RepositorioGenerico<Cidade, Integer>{
    public Cidades() {
        super(Cidade.class);
    }
    
    public List<Cidade> findByEstado(Uf estado) {
        Query q = manager.createQuery("select c from Cidade c where c.ufId = :uf");
        q.setParameter("uf", estado);
        List<Cidade> returnList = q.getResultList();
        return returnList;
    }
}
