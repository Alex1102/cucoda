package com.mycompany.cucoda.model;


import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@XmlRootElement(name = "passport-type")
public enum PassportType {
    PERSONALAUSWEIS,
    REISEPASS;
}
