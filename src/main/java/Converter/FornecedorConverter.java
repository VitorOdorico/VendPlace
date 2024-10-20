package Converter;

import Entidades.ClassePai;
import Entidades.Fornecedor;
import Facade.AbstractFacade;
import Facade.FornecedorFacade;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

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
