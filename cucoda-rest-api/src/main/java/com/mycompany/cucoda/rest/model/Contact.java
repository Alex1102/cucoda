package com.mycompany.cucoda.rest.model;


import java.util.Date;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customer")
public class Contact {


    private ContactId id;
    private String email;
    private String phoneAreaCode;
    private String phoneNumber;
    private Date birthDate;
    private String isoLanguage;
    private CustomerNumber customerNumber;

    public Contact() {
    }

    public Contact(ContactId id, String email, String phoneAreaCode, String phoneNumber, Date birthDate, String isoLanguage, CustomerNumber customerNumber) {
        this.id = id;
        this.email = email;
        this.phoneAreaCode = phoneAreaCode;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.isoLanguage = isoLanguage;
        this.customerNumber = customerNumber;
    }

    @XmlElement(name = "id")
    public ContactId getId() {
        return id;
    }

    @XmlElement(name = "email")
    public String getEmail() {
        return email;
    }

    @XmlElement(name = "phoneAreaCode")
    public String getPhoneAreaCode() {
        return phoneAreaCode;
    }

    @XmlElement(name = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @XmlElement(name = "birthDate")
    public Date getBirthDate() {
        return birthDate;
    }

    @XmlElement(name = "isoLanguage")
    public String getIsoLanguage() {
        return isoLanguage;
    }

    @XmlElement(name = "customerNumber")
    public CustomerNumber getCustomerNumber() {
        return customerNumber;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Contact{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneAreaCode='").append(phoneAreaCode).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", isoLanguage='").append(isoLanguage).append('\'');
        sb.append(", customerNumber=").append(customerNumber);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getId(), contact.getId()) &&
                Objects.equals(getEmail(), contact.getEmail()) &&
                Objects.equals(getPhoneAreaCode(), contact.getPhoneAreaCode()) &&
                Objects.equals(getPhoneNumber(), contact.getPhoneNumber()) &&
                Objects.equals(getBirthDate(), contact.getBirthDate()) &&
                Objects.equals(getIsoLanguage(), contact.getIsoLanguage()) &&
                Objects.equals(getCustomerNumber(), contact.getCustomerNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getPhoneAreaCode(), getPhoneNumber(), getBirthDate(), getIsoLanguage(), getCustomerNumber());
    }
}
