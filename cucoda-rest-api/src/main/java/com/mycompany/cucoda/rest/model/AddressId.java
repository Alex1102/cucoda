package com.mycompany.cucoda.rest.model;


import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "addressId")
public class AddressId implements Serializable {


    private Long id;


    public AddressId() {
    }

    public AddressId(Long id) {
        this.id = id;
    }

    public AddressId(String id) {
        this.id = Long.parseLong(id);
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AddressId{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressId)) return false;
        AddressId addressId = (AddressId) o;
        return Objects.equals(getId(), addressId.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
