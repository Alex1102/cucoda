package com.mycompany.cucoda.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@XmlRootElement(name = "gernder")
public enum Gender implements Serializable {
    MALE,
    FEMALE;
}