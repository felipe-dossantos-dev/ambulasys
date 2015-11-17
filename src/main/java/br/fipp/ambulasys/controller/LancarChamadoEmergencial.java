/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.controller;

import br.fipp.ambulasys.model.ChamadoEmergencial;
import br.fipp.ambulasys.model.Pessoa;
import br.fipp.ambulasys.model.Veiculo;
import br.fipp.ambulasys.repository.ChamadosEmergenciais;
import br.fipp.ambulasys.repository.Pessoas;
import br.fipp.ambulasys.repository.Veiculos;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author felipe
 */
@ViewScoped
@ManagedBean
public class LancarChamadoEmergencial {

    @EJB
    private ChamadosEmergenciais repositorio;
    
    @EJB
    private Veiculos veiculos;
    
    @EJB
    private Pessoas pessoas;
    
    private ChamadoEmergencial chamado;
    
    private Integer chamadoId;
    private Integer hospitalId;
    
    @PostConstruct
    public void init() {
        hospitalId = (Integer) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("hospitalId");
        chamadoId = (Integer) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("chamadoEmergencial");
        if (chamadoId != null)
            chamado = repositorio.findById(chamadoId);
        else
            chamado = new ChamadoEmergencial();
    }

    public ChamadoEmergencial getChamado() {
        return chamado;
    }

    public void setChamado(ChamadoEmergencial chamado) {
        this.chamado = chamado;
    }
    
    public void salvar() {
        this.repositorio.save(chamado);
        this.chamado = new ChamadoEmergencial();
    }
    
    public List<Veiculo> listarVeiculos() {
        return veiculos.findByHospital(hospitalId);
    }
    
    public List<Pessoa> listarMotorista() {
        return pessoas.findByMotoristaHospital(hospitalId);
    }
}
