package Facade;

import Entidades.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "VendPlacePU")
    private EntityManager em;

    private static final Logger LOGGER = Logger.getLogger(UsuarioFacade.class.getName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario buscarPorNomeUsuario(String nomeUsuario) {
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.nomeUsuario = :nomeUsuario", Usuario.class)
                     .setParameter("nomeUsuario", nomeUsuario)
                     .getSingleResult();
        } catch (NoResultException e) {
            LOGGER.log(Level.WARNING, "Usuário não encontrado: {0}", nomeUsuario);
            return null; // Usuário não encontrado
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar usuário: {0}", e.getMessage());
            return null; // Outro erro
        }
    }
}
