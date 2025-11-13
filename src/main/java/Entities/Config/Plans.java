package Entities.Config;

import Entities.ClassePai;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Plans implements Serializable, ClassePai {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String description;
    private Double value_plan;


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

    public Double getValue_plan() {
        return value_plan;
    }

    public void setValue_plan(Double value_plan) {
        this.value_plan = value_plan;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Plans plans = (Plans) o;
        return Objects.equals(id, plans.id) && Objects.equals(description, plans.description) && Objects.equals(value_plan, plans.value_plan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, value_plan);
    }

    @Override
    public String toString() {
        return "Plans{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", value_plan=" + value_plan +
                '}';
    }
}
