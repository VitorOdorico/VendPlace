/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;


import Entidades.Fornecedor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class FornecedorFacade extends AbstractFacade<Fornecedor> {

   

    @PersistenceContext(unitName = "VendPlacePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FornecedorFacade() {
        super(Fornecedor.class);
    }
 // Método para buscar por ID
    public Fornecedor buscarPorId(Long id) {
        return em.find(Fornecedor.class, id);
    }

    // Listar todos os fornecedores
    public List<Fornecedor> listarTodos() {
        return em.createQuery("FROM Fornecedor", Fornecedor.class).getResultList();
    }

}
