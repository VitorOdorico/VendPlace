/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;


import Entidades.UnidadeOperacional;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class UnidadeOperacionalFacade extends AbstractFacade<UnidadeOperacional> {

   

    @PersistenceContext(unitName = "VendPlacePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadeOperacionalFacade() {
        super(UnidadeOperacional.class);
    }


    // Método para buscar por ID
    public UnidadeOperacional buscarPorId(Long id) {
        return em.find(UnidadeOperacional.class, id);
    }

    // Listar todas as unidades operacionais
    public List<UnidadeOperacional> listarTodas() {
        return em.createQuery("FROM UnidadeOperacional", UnidadeOperacional.class).getResultList();
    }
}
