package com.mycompany.cucoda.rest.model;


import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "passport-type")
public enum PassportType {
    PERSONALAUSWEIS,
    REISEPASS;
}
