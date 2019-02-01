package com.mycompany.cucoda.rest.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "gernder")
public enum Gender implements Serializable {
    MALE,
    FEMALE;
}