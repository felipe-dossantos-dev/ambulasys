/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.conversor;

import br.fipp.ambulasys.model.Pessoa;
import br.fipp.ambulasys.repository.Pessoas;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author felipe
 */
@FacesConverter(forClass = Pessoa.class, value = "PessoaConversor")
public class PessoaConversor implements Converter{

    @EJB
    private Pessoas pessoas;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !"".equals(value)){
            try {
                return pessoas.findById(new Integer(value));
            } catch (NumberFormatException e) {
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Pessoa) value).getId().toString();
        } 
        return null;
    }
}
