/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.controller;

import br.fipp.ambulasys.model.Hospital;
import br.fipp.ambulasys.model.Veiculo;
import br.fipp.ambulasys.repository.Hospitais;
import br.fipp.ambulasys.repository.Veiculos;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author João Vitor <jsperandiob@gmail.com>
 */
@ViewScoped
@ManagedBean
public class VeiculoController implements Serializable {

    @EJB
    private Veiculos repositorio;

    @EJB
    private Hospitais hospitais;

    private Veiculo veiculo;

    private List<Veiculo> filtrado;

    public VeiculoController() {
    }

    @PostConstruct
    public void init() {
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
        boolean salvar = veiculo.getId() != null;
        veiculo = repositorio.save(veiculo);
        if (salvar) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Alterado com sucesso",
                            null));
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Cadastro feito com sucesso",
                            null));
        }
        limpar();

    }

    public List<Veiculo> listarveiculos() {
        return repositorio.findAll();
    }

    public List<Veiculo> getFiltrado() {
        return filtrado;
    }

    public void setFiltrado(List<Veiculo> filtrado) {
        this.filtrado = filtrado;
    }

    public void remove() {
        repositorio.delete(veiculo.getId());
    }

    public List<Hospital> listarHospitais() {
        return hospitais.findAll();
    }

    public void limpar() {
        veiculo = new Veiculo();
    }
}
