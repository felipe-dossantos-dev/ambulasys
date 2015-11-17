/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.controller;

import br.fipp.ambulasys.model.ChamadoEmergencial;
import br.fipp.ambulasys.repository.ChamadosEmergenciais;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author felipe
 */
@ViewScoped
@ManagedBean
public class MonitorController {

    @EJB
    private ChamadosEmergenciais repositorio;

    private Integer hospitalId;

    private List<ChamadoEmergencial> listaChamados;

    public MonitorController() {
    }

    @PostConstruct
    public void init() {
        hospitalId = (Integer) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("hospitalId");
        listaChamados = repositorio.findByHospitalENaoLancado(hospitalId);
    }
    
    public void listaVazia() {
        if (listaChamados.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Não existe nenhum chamado aberto",
                            null));
        }
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String irPara(Integer id) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .put("chamadoEmergencial", id);
        return "/restrito/emergencial/lancar";
    }

    public List<ChamadoEmergencial> getListaChamados() {
        return listaChamados;
    }

    public void setListaChamados(List<ChamadoEmergencial> listaChamados) {
        this.listaChamados = listaChamados;
    }
}
