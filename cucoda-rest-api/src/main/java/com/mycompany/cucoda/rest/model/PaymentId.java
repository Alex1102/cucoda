package com.mycompany.cucoda.rest.model;


import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "paymentId")
public class PaymentId implements Serializable {


    private Long id;

    public PaymentId() {}

    public PaymentId(Long id) {
        this.id = id;
    }

    public PaymentId(String id) {
        this.id = Long.parseLong(id);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PaymentId{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentId)) return false;
        PaymentId paymentId = (PaymentId) o;
        return Objects.equals(getId(), paymentId.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
