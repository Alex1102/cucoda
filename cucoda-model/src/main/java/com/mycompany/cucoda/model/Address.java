package com.mycompany.cucoda.model;


import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "address")
public class Address implements Serializable {


    private AddressId id;
    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;
    private CustomerNumber customerNumber;

    public Address() {
    }

    public Address(AddressId id, String street, String houseNumber, String zipCode, String city, CustomerNumber customerNumber) {
        this.id = id;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.customerNumber = customerNumber;
    }

    @XmlElement(name = "id")
    public AddressId getId() {
        return id;
    }

    public void setId(AddressId id) {
        this.id = id;
    }

    @XmlElement(name = "street")
    public String getStreet() {
        return street;
    }

    @XmlElement(name = "houseNumber")
    public String getHouseNumber() {
        return houseNumber;
    }

    @XmlElement(name = "zipCode")
    public String getZipCode() {
        return zipCode;
    }

    @XmlElement(name = "city")
    public String getCity() {
        return city;
    }

    @XmlElement(name = "customerNumber")
    public CustomerNumber getCustomerNumber() {
        return customerNumber;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Address{");
        sb.append("id=").append(id);
        sb.append(", street='").append(street).append('\'');
        sb.append(", houseNumber='").append(houseNumber).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", customerNumber=").append(customerNumber);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getId(), address.getId()) &&
                Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getHouseNumber(), address.getHouseNumber()) &&
                Objects.equals(getZipCode(), address.getZipCode()) &&
                Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getCustomerNumber(), address.getCustomerNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStreet(), getHouseNumber(), getZipCode(), getCity(), getCustomerNumber());
    }
}
