/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.conversor;

import br.fipp.ambulasys.model.Uf;
import br.fipp.ambulasys.repository.Ufs;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author felipe.santos
 */
@FacesConverter(forClass = Uf.class,value = "UfConverter")
public class UfConversor implements Converter{

    @EJB
    private Ufs ufs;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !"".equals(value)) {
            return ufs.findById(new Integer(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Uf) value).getId().toString();
        }
        return null;
    }
    
}
