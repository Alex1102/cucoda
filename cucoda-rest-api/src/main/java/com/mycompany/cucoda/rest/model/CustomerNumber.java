package com.mycompany.cucoda.rest.model;


import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * Macht Sinn, man alleine schon am Typ sehen kann was man in der Hand hat.
 * An einem String sieht man es erst nicht so schnell.
 *
 * Viel wichtiger ist, man kann im Nachhinein den eigentlichen primitiven Datetentyp
 * ändern ohne dafür jede Methode im Code anpassen zu müssen.
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customerNumber")
public class CustomerNumber implements Serializable {


    private static final long serialVersionUID = 1L;
    public static final String MEDIA_TYPE = "application/vnd.cucoda.customernumber-v1+json";

    private Long id;

    public CustomerNumber() {
    }

    public CustomerNumber(Long id) {
        this.id = id;
    }

    public CustomerNumber(String id) {
        this.id = Long.parseLong(id);
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CustomerNumber{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerNumber)) return false;
        CustomerNumber that = (CustomerNumber) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
