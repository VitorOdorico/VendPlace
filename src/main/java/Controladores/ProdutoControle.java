/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;


import Entidades.Produto;
import Facade.ProdutoFacade;
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
public class ProdutoControle implements Serializable{
    private Produto produto;
    @PostConstruct
    public void init() {
        produto = new Produto();
    }
    @EJB
    private ProdutoFacade produtoFacade;

    public ProdutoFacade getProdutoFacade() {
        return produtoFacade;
    }

    public void setProdutoFacade(ProdutoFacade produtoFacade) {
        this.produtoFacade = produtoFacade;
    }
    
    public void novo(){
        produto = new Produto();
    }
    
    public void salvar(){
        produtoFacade.salvar(produto);
        produto = new Produto();
    }
    
    public void excluir(Produto prod){
        produtoFacade.remover(prod);
    }
    
    public void editar(Produto prod){
        this.produto = prod;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

   

    public List<Produto> getListaProdutos() {
        return produtoFacade.listaTodos();
    }    
    
}
