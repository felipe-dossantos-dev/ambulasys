/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.repository;

import br.fipp.ambulasys.model.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author felipe
 */
public class Pessoas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Pessoa guardar(Pessoa pessoa) {
        manager.getTransaction().begin();
        pessoa = manager.merge(pessoa);
        manager.getTransaction().commit();

        return pessoa;
    }

    public List<Pessoa> todos() {
        return manager.createQuery("from Pessoa order by id desc",
                Pessoa.class).getResultList();
    }

    public Pessoa porId(Long id) {
        return manager.find(Pessoa.class, id);
    }
    
}
