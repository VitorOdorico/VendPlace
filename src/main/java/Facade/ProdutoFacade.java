
package Facade;


import Entities.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ProdutoFacade extends AbstractFacade<Product>{
    
    @PersistenceContext(unitName = "VendPlacePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdutoFacade() {
        super(Product.class);
    }

    
}
