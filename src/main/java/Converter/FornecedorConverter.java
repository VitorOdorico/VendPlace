package Converter;

import Entidades.Fornecedor;
import Facade.FornecedorFacade;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "fornecedorConverter")
public class FornecedorConverter implements Converter {

    @Inject
    private FornecedorFacade fornecedorFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        // Obter o fornecedor por ID usando o Facade
        return fornecedorFacade.buscarPorId(Long.valueOf(value));
    }

@Override
public String getAsString(FacesContext context, UIComponent component, Object value) {
    if (value == null) {
        return "";
    }

    // Verifica se o valor é uma instância de Fornecedor
    if (value instanceof Fornecedor) {
        Fornecedor fornecedor = (Fornecedor) value;
        
        // Se o ID é primitivo long, converta para String diretamente
        return String.valueOf(fornecedor.getId()); // Retorna o ID do fornecedor
    }

    // Retorna uma string vazia se o objeto não for do tipo Fornecedor
    return "";
}


}
