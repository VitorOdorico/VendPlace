package Facade;

import Entidades.ItemVenda;
import Entidades.Produto;
import Entidades.Venda;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class VendaFacade extends AbstractFacade<Venda> {

    @PersistenceContext(unitName = "VendPlacePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendaFacade() {
        super(Venda.class);
    }

    // Listar todas as vendas
    public List<Venda> listarTodas() {
        return em.createQuery("FROM Venda", Venda.class).getResultList();
    }
    
    
    
    
    
    @Override
    public void salvar(Venda entity) {
        for(ItemVenda it : entity.getItemvenda()){
            Produto p = it.getProduto();
            p.setEstoque (p.getEstoque()- it.getQuantidade());
            em.merge(p);
        }
        super.salvar(entity);
    }
}
