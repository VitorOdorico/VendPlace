
package Controladores;

import Entidades.UnidadeOperacional;
import Facade.UnidadeOperacionalFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UnidadeOperacionalControle implements Serializable{
    private UnidadeOperacional unidadeOperacional;
    @PostConstruct
    public void init() {
        unidadeOperacional = new UnidadeOperacional();
    }
    @EJB
    private UnidadeOperacionalFacade unidadeOperacionalFacade;
    
    public void novo(){
        unidadeOperacional = new UnidadeOperacional();
    }
    
     public void salvar(){
        unidadeOperacionalFacade.salvar(unidadeOperacional);
        unidadeOperacional = new UnidadeOperacional();
    }
    
    public void excluir(UnidadeOperacional unop){
        unidadeOperacionalFacade.remover(unop);
    }
    
    public void editar(UnidadeOperacional unop){
        this.unidadeOperacional = unop;
    }

    public UnidadeOperacional getUnidadeOperacional() {
        return unidadeOperacional;
    }

    public void setUnidadeOperacional(UnidadeOperacional unidadeOperacional) {
        this.unidadeOperacional = unidadeOperacional;
    }

   

    public List<UnidadeOperacional> getListaUnidadeOperacional() {
        return unidadeOperacionalFacade.listaTodos();
    }    
      public UnidadeOperacional buscarPorId(Long id) {
        return unidadeOperacionalFacade.buscarPorId(id);
    }
}
