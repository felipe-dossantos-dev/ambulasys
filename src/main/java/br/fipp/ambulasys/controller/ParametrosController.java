/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.controller;

import br.fipp.ambulasys.model.Parametros;
import br.fipp.ambulasys.repository.ParametrosRepository;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author felipe
 */
@Named
@SessionScoped
@ManagedBean
public class ParametrosController implements Serializable{

    @EJB
    private ParametrosRepository repositorio;
    
    private UploadedFile file;
    private Parametros parametros;
    
    public ParametrosController() {
    }
    
    @PostConstruct
    public void init(){
        parametros = repositorio.findById(1);
        if (parametros == null) {
            parametros = new Parametros(1);
        }
    }

    public Parametros getParametros() {
        return parametros;
    }

    public void setParametros(Parametros parametros) {
        this.parametros = parametros;
    }
    
    public void salvar() {
        repositorio.save(parametros);
    }
    
    public String confirmar() {
        parametros.setRegistrado(Boolean.TRUE);
        salvar();
        return "/restrito/gerenciamento/parametros?redirect-true";
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    public void upload() {
        if(file != null) {
            parametros.setLogo(file.getContents());
            FacesMessage message = new FacesMessage("Sucesso", "Parametros atualizados!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        salvar();
    }
    
    public StreamedContent getImage() throws FileNotFoundException {
        if (parametros.getLogo() == null) {
            return new DefaultStreamedContent(null);
        }
        return new DefaultStreamedContent(new ByteArrayInputStream(parametros.getLogo()));
    }
}
