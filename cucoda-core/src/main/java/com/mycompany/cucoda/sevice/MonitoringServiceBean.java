package com.mycompany.cucoda.sevice;

import com.mycompany.cucoda.service.MonitoringService;

import javax.ejb.Stateless;

@Stateless
public class MonitoringServiceBean implements MonitoringService {

    @Override
    public String ping() {
        return "pong";
    }
}
