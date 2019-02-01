package com.mycompany.cucoda.rest.model;


import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "contractId")
public class ContactId implements Serializable {

    private Long id;


    public ContactId() {
    }

    public ContactId(Long id) {
        this.id = id;
    }

    public ContactId(String id) {
        this.id = Long.parseLong(id);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ContactId{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactId)) return false;
        ContactId contactId = (ContactId) o;
        return Objects.equals(getId(), contactId.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
