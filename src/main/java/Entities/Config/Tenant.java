package Entities.Config;

import Entities.ClassePai;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Tenant implements Serializable,ClassePai {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String nomeEmpresa;
    private String descricao;
    private String cnpj;
    private String telefone;
    private Date dataCadastro;
    private Date dataUltimoPagamento;
    private Integer competencia;
    private boolean isAtivo;

    @ManyToOne
    private Plans plans;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataUltimoPagamento() {
        return dataUltimoPagamento;
    }

    public void setDataUltimoPagamento(Date dataUltimoPagamento) {
        this.dataUltimoPagamento = dataUltimoPagamento;
    }

    public Integer getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Integer competencia) {
        this.competencia = competencia;
    }

    public Plans getPlans() {
        return plans;
    }

    public void setPlans(Plans plans) {
        this.plans = plans;
    }

    public boolean isAtivo() {
        return isAtivo;
    }

    public void setAtivo(boolean ativo) {
        isAtivo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tenant tenant = (Tenant) o;
        return isAtivo == tenant.isAtivo && Objects.equals(id, tenant.id) && Objects.equals(nomeEmpresa, tenant.nomeEmpresa) && Objects.equals(descricao, tenant.descricao) && Objects.equals(cnpj, tenant.cnpj) && Objects.equals(telefone, tenant.telefone) && Objects.equals(dataCadastro, tenant.dataCadastro) && Objects.equals(dataUltimoPagamento, tenant.dataUltimoPagamento) && Objects.equals(competencia, tenant.competencia) && Objects.equals(plans, tenant.plans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeEmpresa, descricao, cnpj, telefone, dataCadastro, dataUltimoPagamento, competencia, isAtivo, plans);
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "id=" + id +
                ", nomeEmpresa='" + nomeEmpresa + '\'' +
                ", descricao='" + descricao + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", dataUltimoPagamento=" + dataUltimoPagamento +
                ", competencia=" + competencia +
                ", isAtivo=" + isAtivo +
                ", plans=" + plans +
                '}';
    }
}
