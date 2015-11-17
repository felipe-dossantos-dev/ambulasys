package br.fipp.ambulasys.conversor;

import br.fipp.ambulasys.model.Infracao;
import br.fipp.ambulasys.model.Pessoa;
import br.fipp.ambulasys.repository.Infracoes;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author felipe
 */
@FacesConverter(forClass = Infracao.class, value = "InfracaoConversor")
public class InfracaoConversor implements Converter {

    @EJB
    private Infracoes infracoes;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !"".equals(value)) {
            try {
                return infracoes.findById(new Integer(value));
            } catch (NumberFormatException e) {
            }
        }
        return null;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Infracao) value).getId().toString();
        }
        return null;
    }

}
