/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.controller;

import br.fipp.ambulasys.model.Cidade;
import br.fipp.ambulasys.model.Hospital;
import br.fipp.ambulasys.model.Pessoa;
import br.fipp.ambulasys.model.Uf;
import br.fipp.ambulasys.repository.Cidades;
import br.fipp.ambulasys.repository.Hospitais;
import br.fipp.ambulasys.repository.Pessoas;
import br.fipp.ambulasys.repository.Ufs;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
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
    
    @EJB
    private Cidades cidades;
    
    @EJB
    private Ufs ufs;
    
    private Hospital hospital;
    private Uf estado;

    @PostConstruct
    public void init() {
        hospital = new Hospital();
        hospital.setResponsavel(new Pessoa());
    }
    
    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
        this.hospital.setDataInscricao(new Date(System.currentTimeMillis()));
    }
    
    public List<Hospital> listarHospitais() {
        return hospitais.findAll();
    }
    
    public List<Pessoa> listarPessoas() {
        return pessoas.findAll();
    }
    
    public void salvar() {
        hospitais.save(hospital);
    }
    
    public List<Cidade> listarCidades() {
        return cidades.findByEstado(estado);
    }
    
    public List<Uf> listarEstados() {
        return ufs.findAll();
    }

    public Uf getEstado() {
        return estado;
    }

    public void setEstado(Uf estado) {
        this.estado = estado;
    }
}
