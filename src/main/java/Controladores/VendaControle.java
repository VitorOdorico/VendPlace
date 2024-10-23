/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Converter.ConverterGenerico;
import Entidades.Cliente;
import Entidades.Produto;
import Entidades.Venda;
import Facade.ClienteFacade;
import Facade.ProdutoFacade;
import Facade.VendaFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import javax.ejb.EJB;


@ManagedBean
@ViewScoped
public class VendaControle implements Serializable {

    private Venda venda;
    private List<Cliente> listaClientes;
    private List<Produto> listaProdutos;
    @EJB
    private VendaFacade vendafacade;
    @EJB
    private ClienteFacade clientefacade;
    @EJB
    private ProdutoFacade produtofacade;
    
    private ConverterGenerico clienteConverter;
    private ConverterGenerico produtoConverter;
    
    
    @PostConstruct
    public void init() {
        venda = new Venda();
        listaClientes = carregarClientes();
        listaProdutos = carregarProdutos();
    }
    
      public ConverterGenerico getProdutoConverter() {
        if (produtoConverter == null) {
            produtoConverter = new ConverterGenerico(produtofacade);
        }
        return produtoConverter;
    }

    public void setProdutoConverter(ConverterGenerico produtoConverter) {
        this.produtoConverter = produtoConverter;
    }
    

     public ConverterGenerico getClienteConverter() {
        if (clienteConverter == null) {
            clienteConverter = new ConverterGenerico(clientefacade);
        }
        return clienteConverter;
    }

    public void setClienteConverter(ConverterGenerico clienteConverter) {
        this.clienteConverter = clienteConverter;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    public void salvar() {
        // Chama o facade para salvar a venda
        vendafacade.salvar(venda);
    }

    // Métodos para carregar clientes e produtos (simulação)
    private List<Cliente> carregarClientes() {
        // Simula a busca de clientes do banco de dados ou outro serviço
        return clientefacade.listaTodos();
    }

    private List<Produto> carregarProdutos() {
        // Simula a busca de produtos do banco de dados ou outro serviço
        return produtofacade.listaTodos();
    }

    // Getters e Setters
    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}