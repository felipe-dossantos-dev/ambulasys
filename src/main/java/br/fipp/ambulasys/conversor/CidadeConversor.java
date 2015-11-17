/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.conversor;

import br.fipp.ambulasys.model.Cidade;
import br.fipp.ambulasys.repository.Cidades;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author felipe
 */
@FacesConverter(forClass = Cidade.class, value = "CidadeConversor")
public class CidadeConversor implements Converter {

    @EJB
    private Cidades cidades;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !"".equals(value)) {
            try {
                return cidades.findById(new Integer(value));
            } catch (NumberFormatException e) {
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Cidade) value).getId().toString();
        }
        return null;
    }
}
