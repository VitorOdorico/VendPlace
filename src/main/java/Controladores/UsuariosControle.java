package Controladores;

import Entities.Config.Usuario;
import Facade.UsuarioFacade;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Utils.CriptografiaUtil;

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

    public void salvar() {
        try {
            if (usuario.getSenha() != null && !usuario.getSenha().isEmpty()) {
                usuario.setSenha(CriptografiaUtil.criptografar(usuario.getSenha()));
            }
            usuarioFacade.salvar(usuario);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário salvo com sucesso!", null));
            usuario = new Usuario();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar usuário: " + e.getMessage(), null));
            e.printStackTrace();
        }
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
