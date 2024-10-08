package Controladores;

import Entidades.Usuario;
import Facade.UsuarioFacade;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author VCosta
 */
@ManagedBean
@SessionScoped
public class UsuariosControle implements Serializable{
    private Usuario usuario;
    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }
    @EJB
    private UsuarioFacade usuarioFacade;
    
    public void novo(){
        usuario = new Usuario();
    }
    
    public void salvar(){
        usuarioFacade.salvar(usuario);
        usuario = new Usuario();
    }
    
    public void excluir(Usuario us){
        usuarioFacade.remover(us);
    }
    
    public void editar(Usuario us){
        this.usuario = us;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   

    public List<Usuario> getListaUsuarios() {
        return usuarioFacade.listaTodos();
    }    
    
}
