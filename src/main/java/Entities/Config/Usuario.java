package Entities.Config;
import Entities.ClassePai;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author VCosta
 */

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable, ClassePai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nomeCompleto;

    private String cpfCni;

    private String email;

    private String telefone;
    
    @Column(name = "nomeUsuario", unique = true)
    private String nomeUsuario;

    @Column(name = "senha", length = 60, nullable = false)
    private String senha;

    @ManyToOne
    private Tenant tenant;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpfCni() {
        return cpfCni;
    }

    public void setCpfCni(String cpfCni) {
        this.cpfCni = cpfCni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

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

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nomeCompleto, usuario.nomeCompleto) && Objects.equals(cpfCni, usuario.cpfCni) && Objects.equals(email, usuario.email) && Objects.equals(telefone, usuario.telefone) && Objects.equals(nomeUsuario, usuario.nomeUsuario) && Objects.equals(senha, usuario.senha) && Objects.equals(tenant, usuario.tenant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeCompleto, cpfCni, email, telefone, nomeUsuario, senha, tenant);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", cpfCni='" + cpfCni + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", senha='" + senha + '\'' +
                ", tenant=" + tenant +
                '}';
    }
}
