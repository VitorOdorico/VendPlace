/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

/**
 *
 * @author VCosta
 */


import Entities.Config.Usuario;
import Facade.UsuarioFacade;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import Utils.CriptografiaUtil;


@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private String nomeUsuario;
    private String senha;
    private Usuario usuarioAutenticado;

    @EJB
    private UsuarioFacade usuarioFacade;

    public String login() {
        Usuario usuario = usuarioFacade.buscarPorNomeUsuario(nomeUsuario);

        if (usuario != null) {
            System.out.println("Hash no banco: " + usuario.getSenha());
            System.out.println("Senha fornecida: " + senha);

            if (CriptografiaUtil.verificarSenha(senha, usuario.getSenha())) {
                usuarioAutenticado = usuario;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
                return "index?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha incorreta", null));
                return null;
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado", null));
            return null;
        }
    }


    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login?faces-redirect=true";
    }


    // Getters e Setters
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }
}
