/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.controller;

import br.fipp.ambulasys.repository.Cidades;
import br.fipp.ambulasys.repository.Hospitais;
import br.fipp.ambulasys.repository.Pessoas;
import br.fipp.ambulasys.repository.Ufs;
import br.fipp.ambulasys.view.helper.HospitalViewHelper;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author felipe
 */
@SessionScoped
@ManagedBean
public class HospitalController implements Serializable {

    @EJB
    private Hospitais hospitais;

    @EJB
    private Pessoas pessoas;

    @EJB
    private Cidades cidades;

    @EJB
    private Ufs ufs;

    private HospitalViewHelper helper;

    public HospitalController() {
    }

    @PostConstruct
    public void init() {
        helper = new HospitalViewHelper();
        loadValues();
    }

    private void loadValues() {
        helper.setPessoas(pessoas.findAll());
        helper.setHospitais(hospitais.findAll());
        helper.setEstados(ufs.findAll());
    }

    public void salvar() {
        helper.viewToObject();
        helper.getHospital().setDataInscricao(new Date());
        helper.setHospital(hospitais.save(helper.getHospital()));

        if (!helper.getHospitais().contains(helper.getHospital())) {
            helper.getHospitais().add(helper.getHospital());
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Cadastro feito com sucesso",
                            null));

        } else {
            helper.setHospitais(hospitais.findAll());
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Alterado com sucesso",
                            null));
        }
        helper.resetValues();

    }

    public void naMudancaEstado() {
        if (helper.getEstado() == null) {
            helper.setListaCidades(cidades.findAll());
        } else {
            helper.setListaCidades(cidades.findByEstado(helper.getEstado()));
        }
    }

    public HospitalViewHelper getHelper() {
        return helper;
    }

    public void setHelper(HospitalViewHelper helper) {
        this.helper = helper;
    }

    public void editar() {
        helper.setListaCidades(cidades.findByEstado(helper.getHospital().getCidadeId().getUfId()));
        helper.editar();
    }

    public void limpar() {
        helper.resetValues();
    }

    public void remove() {
        hospitais.delete(helper.getHospital().getId());
        helper.getHospitais().remove(helper.getHospital());
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Excluido",
                        null));
        helper.resetValues();
    }
}
