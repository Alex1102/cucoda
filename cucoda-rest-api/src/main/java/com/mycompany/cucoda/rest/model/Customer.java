package com.mycompany.cucoda.rest.model;

import static com.mycompany.cucoda.model.Market.MY_COMPANY;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customer")
public class Customer implements Serializable {


    public static final String MEDIA_TYPE = "application/vnd.cucoda.customer-v1+json";


    public CustomerNumber customerNumber;
    public String marketId;
    public Date validFrom;
    public Date validTo;


    public LocalDateTime createdAt;


    public Customer() {
		this.marketId = MY_COMPANY.getId();
		this.validFrom = new Date();
		this.createdAt = LocalDateTime.now();
    }

    public Customer(final CustomerNumber customerNumber, final String marketId) {
        super();
        this.customerNumber = customerNumber;
        this.marketId = marketId;
        this.validFrom = new Date();
        this.createdAt = LocalDateTime.now();
    }


    public CustomerNumber getCustomerNumber() {
        return customerNumber;
    }

    public String getMarketId() {
        return marketId;
    }
    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }
    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Customer{");
        sb.append("customerNumber=").append(customerNumber);
        sb.append(", marketId='").append(marketId).append('\'');
        sb.append(", validFrom=").append(validFrom);
        sb.append(", validTo=").append(validTo);
        sb.append(", createdAt=").append(createdAt);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getCustomerNumber(), customer.getCustomerNumber()) &&
                Objects.equals(getMarketId(), customer.getMarketId()) &&
                Objects.equals(getValidFrom(), customer.getValidFrom()) &&
                Objects.equals(getValidTo(), customer.getValidTo()) &&
                Objects.equals(getCreatedAt(), customer.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerNumber(), getMarketId(), getValidFrom(), getValidTo(), getCreatedAt());
    }
}
