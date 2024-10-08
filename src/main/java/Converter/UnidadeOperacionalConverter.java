/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converter;

/**
 *
 * @author VCosta
 */
import Entidades.UnidadeOperacional;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "unidadeOperacionalConverter")
public class UnidadeOperacionalConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.isEmpty()) {
            try {
                return component.getAttributes().get("unidadeOperacional_" + Long.parseLong(value));
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof UnidadeOperacional) {
            UnidadeOperacional unidade = (UnidadeOperacional) value;
            if (unidade != null && unidade.getId() != null) {
                component.getAttributes().put("unidadeOperacional_" + unidade.getId(), unidade);
                return unidade.getId().toString();
            }
        }
        return "";
    }
}
