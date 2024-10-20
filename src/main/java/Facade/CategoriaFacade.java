package Facade;


import Entidades.Categoria;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@ManagedBean
@RequestScoped
public class CategoriaFacade extends AbstractFacade<Categoria> {

   

    @PersistenceContext(unitName = "VendPlacePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaFacade() {
        super(Categoria.class);
    }

     public Categoria buscarPorId(Long id) {
        return em.find(Categoria.class, id);
    }

    // Listar todas as categorias
    public List<Categoria> listarTodas() {
        return em.createQuery("FROM Categoria", Categoria.class).getResultList();
    }
}
