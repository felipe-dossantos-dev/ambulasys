/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.controller;

import br.fipp.ambulasys.model.ChamadoEmergencial;
import br.fipp.ambulasys.model.Hospital;
import br.fipp.ambulasys.repository.ChamadosEmergenciais;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import static javax.ws.rs.client.Entity.entity;

/**
 *
 * @author felipe
 */
@ManagedBean
@ViewScoped
public class AbrirChamadoController {

    @EJB
    private ChamadosEmergenciais repositorio;

    private ChamadoEmergencial chamado;
    private Integer hospitalId;

    @PostConstruct
    public void init() {
        chamado = new ChamadoEmergencial();
        hospitalId = (Integer) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("hospitalId");
    }

    public ChamadoEmergencial getChamado() {
        return chamado;
    }

    public void setChamado(ChamadoEmergencial chamado) {
        this.chamado = chamado;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public void abrir() {
        try {
            chamado.setDataAbertura(new Date());
            chamado.setHospitalId(new Hospital(hospitalId));
            repositorio.save(chamado);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Chamado emergencial aberto com sucesso",
                            null));
        } catch (Exception e) {
            System.out.println(e);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Erro ao abrir o chamado emergencial",
                            null));
        }
    }
}
