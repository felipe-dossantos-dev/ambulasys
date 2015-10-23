/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.controller;

import br.fipp.ambulasys.repository.Regioes;
import br.fipp.ambulasys.model.Regiao;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author felipe
 */
@Named
@ViewScoped
public class TesteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private Regioes regioes;
    
    public String gerarTeste(){
        return regioes.porId(1).getNome();
    }
}
