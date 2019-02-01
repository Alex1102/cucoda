package com.mycompany.cucoda.rest.model;


import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "payment")
public class Payment implements Serializable {


    private PaymentId id;
    private String accountHolder;
    private String bankAccount;             // 1689123809
    private String bankCode;                // 66010075
    private String bankIBAN;                // DE23600100700712901700
    private String bankName;                // Volksbank
    private CustomerNumber customerNumber;


    public Payment() {
    }

    public Payment(PaymentId id, String accountHolder, String bankAccount, String bankCode, String bankIBAN, String bankName, CustomerNumber customerNumber) {
        this.id = id;
        this.accountHolder = accountHolder;
        this.bankAccount = bankAccount;
        this.bankCode = bankCode;
        this.bankIBAN = bankIBAN;
        this.bankName = bankName;
        this.customerNumber = customerNumber;
    }

    @XmlElement(name = "id")
    public PaymentId getId() {
        return id;
    }

    @XmlElement(name = "accountHolder")
    public String getAccountHolder() {
        return accountHolder;
    }

    @XmlElement(name = "bankAccount")
    public String getBankAccount() {
        return bankAccount;
    }

    @XmlElement(name = "bankCode")
    public String getBankCode() {
        return bankCode;
    }

    @XmlElement(name = "bankIBAN")
    public String getBankIBAN() {
        return bankIBAN;
    }

    @XmlElement(name = "bankName")
    public String getBankName() {
        return bankName;
    }

    @XmlElement(name = "customer")
    public CustomerNumber getCustomerNumber() {
        return customerNumber;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Payment{");
        sb.append("id=").append(id);
        sb.append(", accountHolder='").append(accountHolder).append('\'');
        sb.append(", bankAccount='").append(bankAccount).append('\'');
        sb.append(", bankCode='").append(bankCode).append('\'');
        sb.append(", bankIBAN='").append(bankIBAN).append('\'');
        sb.append(", bankName='").append(bankName).append('\'');
        sb.append(", customerNumber=").append(customerNumber);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return Objects.equals(getId(), payment.getId()) &&
                Objects.equals(getAccountHolder(), payment.getAccountHolder()) &&
                Objects.equals(getBankAccount(), payment.getBankAccount()) &&
                Objects.equals(getBankCode(), payment.getBankCode()) &&
                Objects.equals(getBankIBAN(), payment.getBankIBAN()) &&
                Objects.equals(getBankName(), payment.getBankName()) &&
                Objects.equals(getCustomerNumber(), payment.getCustomerNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountHolder(), getBankAccount(), getBankCode(), getBankIBAN(), getBankName(), getCustomerNumber());
    }
}
