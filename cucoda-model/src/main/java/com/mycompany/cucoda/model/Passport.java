package com.mycompany.cucoda.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "passport")
public class Passport implements Serializable {


    private PassportId id;
    private String passportNumber;
    private String countryId;
    private String passportType;
    private String validUntil;
    private CustomerNumber customerNumber;


    public Passport() {
    }

    public Passport(PassportId id, String passportNumber, String countryId, String passportType, String validUntil, CustomerNumber customerNumber) {
        this.id = id;
        this.passportNumber = passportNumber;
        this.countryId = countryId;
        this.passportType = passportType;
        this.validUntil = validUntil;
        this.customerNumber = customerNumber;
    }


    @XmlElement(name = "id")
    public PassportId getId() {
        return id;
    }

    @XmlElement(name = "passportNumber")
    public String getPassportNumber() {
        return passportNumber;
    }

    @XmlElement(name = "countryId")
    public String getCountryId() {
        return countryId;
    }

    @XmlElement(name = "passportType")
    public String getPassportType() {
        return passportType;
    }

    @XmlElement(name = "validUntil")
    public String getValidUntil() {
        return validUntil;
    }

    @XmlElement(name = "customerNumber")
    public CustomerNumber getCustomerNumber() {
        return customerNumber;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Passport{");
        sb.append("id=").append(id);
        sb.append(", passportNumber='").append(passportNumber).append('\'');
        sb.append(", countryId='").append(countryId).append('\'');
        sb.append(", passportType='").append(passportType).append('\'');
        sb.append(", validUntil='").append(validUntil).append('\'');
        sb.append(", customerNumber=").append(customerNumber);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passport)) return false;
        Passport passport = (Passport) o;
        return Objects.equals(getId(), passport.getId()) &&
                Objects.equals(getPassportNumber(), passport.getPassportNumber()) &&
                Objects.equals(getCountryId(), passport.getCountryId()) &&
                Objects.equals(getPassportType(), passport.getPassportType()) &&
                Objects.equals(getValidUntil(), passport.getValidUntil()) &&
                Objects.equals(getCustomerNumber(), passport.getCustomerNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPassportNumber(), getCountryId(), getPassportType(), getValidUntil(), getCustomerNumber());
    }

}
