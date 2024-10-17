package com.example;

import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery( name = "Person.findSpecific",query = "select u from Person u where u.name = 'Mahmoud'"),
        @NamedQuery(name = "Person.findByName", query = "select u from Person u where u.name = :name")
})
@NamedStoredProcedureQuery(
        name = "Person.plus1",
        procedureName = "plus1inout",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "arg", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "res", type = Integer.class)
        }
)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}