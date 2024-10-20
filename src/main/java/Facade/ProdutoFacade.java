
package Facade;


import Entidades.Produto;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ManagedBean
@RequestScoped
@Stateless
public class ProdutoFacade extends AbstractFacade<Produto>{
     @PersistenceContext(unitName = "VendPlacePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdutoFacade() {
        super(Produto.class);
    }

    
}
