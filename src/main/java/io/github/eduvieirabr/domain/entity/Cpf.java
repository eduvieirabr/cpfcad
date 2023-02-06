package io.github.eduvieirabr.domain.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cpf")
public class Cpf {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "cpf", length = 12)
    private String cpf;

    @Column(name = "active")
    private Boolean active;

    public Cpf() {

    }
    public Cpf(Integer id, String cpf, Boolean active) {
        this.id = id;
        this.cpf = cpf;
        this.active = active;
    }

    public Cpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getId() {
        return  id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return  "Cpf{" +
                "id=" + id +
                ",cpf='"+cpf+ "'" +
                ",active="+active+
                "}";

    }
}
