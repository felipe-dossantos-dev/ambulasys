/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.controller;

import br.fipp.ambulasys.model.Veiculo;
import br.fipp.ambulasys.repository.Veiculos;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author João Vitor <jsperandiob@gmail.com>
 */
@Named
@ViewScoped
@ManagedBean
public class VeiculoController implements Serializable{
    
    @EJB
    private Veiculos repositorio;
    
    private Veiculo veiculo;

    public VeiculoController() {
        this.veiculo = new Veiculo();
    }
    

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    public void salvar() {
        repositorio.save(veiculo);
    }
    
    
    
    
}
