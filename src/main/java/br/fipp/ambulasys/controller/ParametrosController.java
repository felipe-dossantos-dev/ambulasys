/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.controller;

import br.fipp.ambulasys.model.Hospital;
import br.fipp.ambulasys.model.Parametros;
import br.fipp.ambulasys.repository.Hospitais;
import br.fipp.ambulasys.repository.ParametrosRepository;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author felipe
 */
@Named
@Dependent
@ManagedBean
public class ParametrosController {

    @EJB
    private ParametrosRepository repositorio;
    
    private UploadedFile file;
    
    public ParametrosController() {
    }
    
    @PostConstruct
    public void init(){
    }
    
    public Parametros getParametros() {
        return repositorio.findById(1);
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
