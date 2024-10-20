/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe que representa a entidade Cliente.
 * Implementa a interface Serializable, permitindo que seus objetos sejam 
 * convertidos em bytes para serem gravados em disco ou transmitidos via rede.
 * Também implementa a interface ClassePai, que provavelmente contém métodos 
 * comuns às classes que representam entidades do sistema.
 * 
 * A entidade Cliente contém os principais atributos para representar um cliente,
 * incluindo ID, nome, CPF/CNPJ, CNI, endereço, número de telefone e e-mail.
 * 
 * A classe usa a anotação @Id para indicar que o campo 'id' é a chave primária 
 * da entidade, e @GeneratedValue para gerar automaticamente os valores do ID 
 * usando a estratégia AUTO.
 * 
 * A classe também contém métodos getter e setter para os seus atributos, 
 * além de métodos padrão como hashCode, equals e toString.
 * 
 * @author VCosta
 */
@Entity
public class Cliente implements Serializable, ClassePai {
    
    private static final long serialVersionUID = 1L;  // Número de versão da classe para serialização
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  // Identificador único do cliente, gerado automaticamente
    
    private String nome;  // Nome do cliente
    private String cpfCnpj;  // CPF ou CNPJ do cliente
    private String cni;  // CNI (Cadastro Nacional de Inscrição), um número único de identificação
    private String endereco;  // Endereço do cliente
    private String numeroTelefone;  // Número de telefone do cliente
    private String email;  // Endereço de e-mail do cliente

    /**
     * Retorna o nome do cliente.
     * @return o nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do cliente.
     * @param nome o nome do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o CPF ou CNPJ do cliente.
     * @return o CPF ou CNPJ do cliente.
     */
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    /**
     * Define o CPF ou CNPJ do cliente.
     * @param cpfCnpj o CPF ou CNPJ do cliente.
     */
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    /**
     * Retorna o CNI do cliente.
     * @return o CNI do cliente.
     */
    public String getCni() {
        return cni;
    }

    /**
     * Define o CNI do cliente.
     * @param cni o CNI do cliente.
     */
    public void setCni(String cni) {
        this.cni = cni;
    }

    /**
     * Retorna o endereço do cliente.
     * @return o endereço do cliente.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço do cliente.
     * @param endereco o endereço do cliente.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Retorna o número de telefone do cliente.
     * @return o número de telefone do cliente.
     */
    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    /**
     * Define o número de telefone do cliente.
     * @param numeroTelefone o número de telefone do cliente.
     */
    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    /**
     * Retorna o e-mail do cliente.
     * @return o e-mail do cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o e-mail do cliente.
     * @param email o e-mail do cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna o ID do cliente, que é a chave primária.
     * @return o ID do cliente.
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do cliente.
     * @param id o ID do cliente.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gera o código hash da instância do Cliente com base no ID.
     * @return o código hash gerado.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Verifica se o objeto atual é igual a outro objeto, comparando os IDs.
     * @param object o objeto a ser comparado.
     * @return true se os IDs forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Retorna uma representação em String do objeto Cliente.
     * @return uma String que representa o Cliente, incluindo o ID.
     */
    @Override
    public String toString() {
        return "entidades.Cliente[ id=" + id + " ]";
    }

}
