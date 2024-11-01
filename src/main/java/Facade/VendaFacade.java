package Facade;

import Entidades.ItemVenda;
import Entidades.Produto;
import Entidades.Venda;
import java.util.Date;
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
    
    public List<Venda> buscarVendasPorPeriodo(Date startDate, Date endDate) {
        TypedQuery<Venda> query = em.createQuery(
                "SELECT v FROM Venda v WHERE v.dataVenda BETWEEN :startDate AND :endDate", Venda.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
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
