package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade que representa uma Venda.
 */
@Entity
public class Venda implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVenda;
     
    @ManyToOne
    private Cliente cliente;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "venda")
    private List<ItemVenda> itemVenda;

    // Novo atributo para armazenar o valor total
    private Double valorTotal;

    public Venda() {
        itemVenda = new ArrayList<>();
        dataVenda = new Date();
        valorTotal = 0d;  // Inicializa o valor total
    }
    
    public List<ItemVenda> getItemVenda() {
        return itemVenda;
    }
    
    public void setItemVenda(List<ItemVenda> itemVenda) {
        this.itemVenda = itemVenda;
        atualizarValorTotal();  // Atualiza o valor total ao definir os itens
    }
    
    // Método para atualizar o valor total com base nos itens da venda
      private void atualizarValorTotal() {
        valorTotal = 0d;
        for (ItemVenda it : itemVenda) {
            valorTotal += it.getSubtotal();
        }
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItemvenda() {
        return itemVenda;
    }

    public void setItemvenda(List<ItemVenda> itemvenda) {
        this.itemVenda = itemvenda;
        atualizarValorTotal();  // Atualiza o valor total ao definir os itens
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorTotal() {
        return valorTotal;  // Método para acessar o valor total
    }
    public Double getTotal() {
    Double total = 0d;
    for (ItemVenda it : itemVenda) {
        total = total + it.getSubtotal(); // Aqui você soma o subtotal de cada item
    }
    return total;
}
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Entidades.Venda[ id=" + id + " ]";
    }
}
