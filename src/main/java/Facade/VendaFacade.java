package Facade;

import Entidades.Venda;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Facade para a entidade Venda.
 */
@ManagedBean
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
}
