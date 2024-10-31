/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Converter.ConverterGenerico;
import Entidades.Cliente;
import Entidades.ItemVenda;
import Entidades.Produto;
import Entidades.Venda;
import Facade.ClienteFacade;
import Facade.ProdutoFacade;
import Facade.VendaFacade;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class VendaControle implements Serializable {

    private Venda venda;
      @PostConstruct
    public void init() {
        venda = new Venda(); // Inicializa o objeto venda
    }
    private ItemVenda itemVenda;
     public VendaControle() {
        itemVenda = new ItemVenda(); // Inicializa itemVenda para evitar o erro
    }
    @EJB
    private VendaFacade vendafacade;
    @EJB
    private ClienteFacade clienteFacade;
    @EJB
    private ProdutoFacade produtoFacade;

    private ConverterGenerico clienteConverter;
    private ConverterGenerico produtoConverter;

    public void atualizaPreco() {
        itemVenda.setPreco(itemVenda.getProduto().getValor());
    }
   
    public ConverterGenerico getProdutoConverter() {
        if (produtoConverter == null) {
            produtoConverter = new ConverterGenerico(produtoFacade);
        }
        return produtoConverter;
    }

    public void setProdutoConverter(ConverterGenerico produtoConverter) {
        this.produtoConverter = produtoConverter;
    }

    public VendaFacade getVendafacade() {
        return vendafacade;
    }

    public void setVendafacade(VendaFacade vendafacade) {
        this.vendafacade = vendafacade;
    }

    public ClienteFacade getClienteFacade() {
        return clienteFacade;
    }

    public void setClienteFacade(ClienteFacade clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    public ProdutoFacade getProdutoFacade() {
        return produtoFacade;
    }

    public void setProdutoFacade(ProdutoFacade produtoFacade) {
        this.produtoFacade = produtoFacade;
    }

     public ItemVenda getItemvenda() {
        return itemVenda;
    }

    public ItemVenda getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(ItemVenda itemVenda) {
        this.itemVenda = itemVenda;
    }

    public void setItemvenda(ItemVenda itemVenda) {
        this.itemVenda = itemVenda;
    }

     public List<Cliente> getListaClientesFiltrando(String filtro) {
        return clienteFacade.listaFiltrando(filtro, "nome", "cpfCnpj");
    }

    public List<Produto> getListaProdutosFiltrando(String filtro) {
        return produtoFacade.listaFiltrando(filtro, "nome");
    }
    public void adicionarItem() {
    int estoque = itemVenda.getProduto().getEstoque();
    ItemVenda itemTemp = null;
    for (ItemVenda it : venda.getItemvenda()) {
        if (it.getProduto().getId().equals(itemVenda.getProduto().getId())) {
            itemTemp = it;
            estoque = estoque - it.getQuantidade();
        }
    }
    if (estoque < itemVenda.getQuantidade()) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_ERROR, "Estoque insuficiente!", "Restam apenas "
                + estoque + " unidade!"));
    } else {
        if (itemTemp == null) {
            itemVenda.setVenda(venda);
            venda.getItemvenda().add(itemVenda);
        } else {
            itemTemp.setQuantidade(itemTemp.getQuantidade() + itemVenda.getQuantidade());
        }
        
        venda.setValorTotal(venda.getTotal());  // Atualiza o valor total
        itemVenda = new ItemVenda();
    }
}
public Double getValorTotalVenda() {
    return venda.getTotal();
}

    
    public ConverterGenerico getClienteConverter() {
        if (clienteConverter == null) {
            clienteConverter = new ConverterGenerico(clienteFacade);
        }
        return clienteConverter;
    }
     public void setClienteConverter(ConverterGenerico clienteConverter) {
        this.clienteConverter = clienteConverter;
    }
      public void novo() {
        venda = new Venda();
        itemVenda = new ItemVenda();
    }

    public void salvar() {
        vendafacade.salvar(venda);
        venda = new Venda();
    }

    public void excluir(Venda ve) {
        vendafacade.remover(ve);
    }

    public void editar(Venda ve) {
        this.venda = ve;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public List<Venda> getListaVendas() {
        return vendafacade.listaTodos();
    }
     
}
