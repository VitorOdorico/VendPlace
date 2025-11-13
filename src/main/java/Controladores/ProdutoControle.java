/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;


import Entities.Product;
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
    private Product product;
    @PostConstruct
    public void init() {
        product = new Product();
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
        product = new Product();
    }
    
    public void salvar(){
        produtoFacade.salvar(product);
        product = new Product();
    }
    
    public void excluir(Product prod){
        produtoFacade.remover(prod);
    }
    
    public void editar(Product prod){
        this.product = prod;
    }

    public Product getProduto() {
        return product;
    }

    public void setProduto(Product product) {
        this.product = product;
    }

   

    public List<Product> getListaProdutos() {
        return produtoFacade.listaTodos();
    }    
    
}
