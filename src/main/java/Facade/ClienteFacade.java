/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entidades.Categoria;
import Entidades.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author VCosta
 */
@ManagedBean
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

   

    @PersistenceContext(unitName = "VendPlacePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }


    // Listar todas as categorias
    public List<Cliente> listarTodas() {
        return em.createQuery("FROM Cliente", Cliente.class).getResultList();
    }
}
