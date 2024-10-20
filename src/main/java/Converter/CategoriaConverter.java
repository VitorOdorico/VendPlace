
package Converter;

/**
 *
 * @author VCosta
 */

import Entidades.ClassePai;
import Facade.AbstractFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class CategoriaConverter implements Converter {
   private AbstractFacade abstractFacade;

    public CategoriaConverter(AbstractFacade abstractFacade) {
        this.abstractFacade = abstractFacade;
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return abstractFacade.buscar(Long.parseLong(value));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((ClassePai)o).getId().toString();
    }
}
