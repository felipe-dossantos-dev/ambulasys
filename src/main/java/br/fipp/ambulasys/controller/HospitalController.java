/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.controller;

import br.fipp.ambulasys.model.Hospital;
import br.fipp.ambulasys.model.Pessoa;
import br.fipp.ambulasys.repository.Hospitais;
import br.fipp.ambulasys.repository.Pessoas;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author felipe
 */
@Named
@ViewScoped
@ManagedBean
public class HospitalController implements Serializable{
    
    @EJB
    private Hospitais hospitais;
    
    @EJB
    private Pessoas pessoas;
    
    private Hospital hospital;

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
    
    public List<Hospital> listarHospitais() {
        return hospitais.findAll();
    }
    
    public List<Pessoa> listarPessoas() {
        return pessoas.findAll();
    }
}
