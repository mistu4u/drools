package com.example.drools.controller;

import com.example.drools.config.DroolConfig;
import com.example.drools.domain.Offer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DroolsController {
    @Autowired
    private DroolConfig droolConfig;
    @PostMapping
    public Offer getOffer(@RequestBody Offer offer) throws IOException {
        KieSession kSession = droolConfig.getKieSession();
        kSession.insert(offer);
        kSession.fireAllRules();
        return offer;
    }
}
