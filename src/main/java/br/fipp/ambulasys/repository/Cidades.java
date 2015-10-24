/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.repository;

import br.fipp.ambulasys.model.Cidade;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

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
}
