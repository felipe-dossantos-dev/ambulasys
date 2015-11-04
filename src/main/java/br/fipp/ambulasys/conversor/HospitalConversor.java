/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.conversor;

import br.fipp.ambulasys.model.Hospital;
import br.fipp.ambulasys.repository.Hospitais;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author João Vitor <jsperandiob@gmail.com>
 */
@FacesConverter("HpConverter")
public class HospitalConversor implements Converter {

    @EJB
    private Hospitais hosp;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !"".equals(value)) {
            try {
                return hosp.findById(new Integer(value));
            } catch (NumberFormatException e) {
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Hospital) {
            return ((Hospital) value).getId().toString();
        }
        return null;
    }

}
