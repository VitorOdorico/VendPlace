/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Entidades.Fornecedor;
import Facade.FornecedorFacade;
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
public class FornecedorControle implements Serializable{
    private Fornecedor fornecedor;
    @PostConstruct
    public void init() {
        fornecedor = new Fornecedor();
    }
    @EJB
    private FornecedorFacade fornecedorFacade;
    
    public void novo(){
        fornecedor = new Fornecedor();
    }
    
    public void salvar(){
        fornecedorFacade.salvar(fornecedor);
        fornecedor = new Fornecedor();
    }
    
    public void excluir(Fornecedor forn){
        fornecedorFacade.remover(forn);
    }
    
    public void editar(Fornecedor forn){
        this.fornecedor = forn;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

   

    public List<Fornecedor> getListaFornecedor() {
        return fornecedorFacade.listaTodos();
    }    
    public Fornecedor buscarPorId(Long id) {
        return fornecedorFacade.buscarPorId(id);
    }
}
