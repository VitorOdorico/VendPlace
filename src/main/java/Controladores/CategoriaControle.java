/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Entidades.Categoria;
import Facade.CategoriaFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author VCosta
 */
@ManagedBean
@SessionScoped
public class CategoriaControle  implements Serializable{
    
    private Categoria categoria;
    @PostConstruct
    public void init() {
        categoria = new Categoria();
    }
    @EJB
    private CategoriaFacade categoriaFacade;
    
    public void novo(){
        categoria = new Categoria();
    }
    
    public void salvar(){
        categoriaFacade.salvar(categoria);
        categoria = new Categoria();
    }
    
    public void excluir(Categoria cat){
        categoriaFacade.remover(cat);
    }
    
    public void editar(Categoria cat){
        this.categoria = cat;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

   

    public List<Categoria> getListaCategorias() {
        return categoriaFacade.listaTodos();
    }    
    public Categoria buscarPorId(Long id) {
        return categoriaFacade.buscarPorId(id);
    }
    
}
