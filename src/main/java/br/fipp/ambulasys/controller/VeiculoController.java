/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.controller;

import br.fipp.ambulasys.model.Veiculo;
import br.fipp.ambulasys.repository.Veiculos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
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
    }
    
    @PostConstruct
    public void init(){
        if (veiculo == null) {
            veiculo = new Veiculo();
        }
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
    
    public List<Veiculo> listarveiculos() {
        return repositorio.findAll();
    }
    
    public void remove() {
      repositorio.delete(veiculo.getId());
    }
    
//    public void onRowSelect(SelectEvent event) {
//        FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
// 
//    public void onRowUnselect(UnselectEvent event) {
//        FacesMessage msg = new FacesMessage("Car Unselected", ((Car) event.getObject()).getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
    
    
    
    
}
