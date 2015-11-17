/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Classe genérica de um repositório
 * @author felipe
 * @param <E> classe na qual quer desenvolver o repositorio
 * @param <ID> id da classe E
 */
public abstract class RepositorioGenerico<E, ID extends Serializable> implements Serializable {

    @PersistenceContext(unitName = "ambulasysPU") 
    protected EntityManager manager;
    private Class<E> klass;

    public RepositorioGenerico() {
    }

    public RepositorioGenerico(final Class<E> persistentClass) {
        this.klass = persistentClass;
    }
    
    @SuppressWarnings("unchecked")
    public List<E> findAll() {
        Query q = manager.createQuery("select e from " + klass.getSimpleName() + " e");
        List<E> returnList = q.getResultList();
        return returnList;
    }

    public E findById(final ID id) {
        return manager.find(klass, id);
    }

    public void delete(final ID id) {
        Query query = manager.createQuery("delete from " + klass.getName() + " k where k.id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public E save(E entity) {
        return manager.merge(entity);
    }
}
