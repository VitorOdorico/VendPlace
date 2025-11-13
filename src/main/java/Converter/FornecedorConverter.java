package Converter;

import Entities.ClassePai;
import Facade.AbstractFacade;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class FornecedorConverter implements Converter {

    private AbstractFacade abstractFacade;

    public FornecedorConverter(AbstractFacade abstractFacade) {
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
