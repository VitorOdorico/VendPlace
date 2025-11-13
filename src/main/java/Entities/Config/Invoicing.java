package Entities.Config;

import Entities.ClassePai;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Invoicing implements Serializable, ClassePai {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String description;
    private Date created;
    private Date maturity;
    private Date modified;
    private Date deleted;
    private boolean isDeleted;
    private Double price;
    private boolean isPago;

    @ManyToOne
    private Tenant tenant;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getMaturity() {
        return maturity;
    }

    public void setMaturity(Date maturity) {
        this.maturity = maturity;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isPago() {
        return isPago;
    }

    public void setPago(boolean pago) {
        isPago = pago;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public String toString() {
        return "Invoicing{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", maturity=" + maturity +
                ", modified=" + modified +
                ", deleted=" + deleted +
                ", isDeleted=" + isDeleted +
                ", price=" + price +
                ", isPago=" + isPago +
                ", tenant=" + tenant +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Invoicing invoicing = (Invoicing) o;
        return isDeleted == invoicing.isDeleted && isPago == invoicing.isPago && Objects.equals(id, invoicing.id) && Objects.equals(description, invoicing.description) && Objects.equals(created, invoicing.created) && Objects.equals(maturity, invoicing.maturity) && Objects.equals(modified, invoicing.modified) && Objects.equals(deleted, invoicing.deleted) && Objects.equals(price, invoicing.price) && Objects.equals(tenant, invoicing.tenant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, created, maturity, modified, deleted, isDeleted, price, isPago, tenant);
    }
}
