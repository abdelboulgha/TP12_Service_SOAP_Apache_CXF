package com.example.tp12_service_soap_apache_cxf.impl;

import com.example.tp12_service_soap_apache_cxf.api.HelloService;
import com.example.tp12_service_soap_apache_cxf.model.Person;
import jakarta.jws.WebService;

@WebService(
        serviceName = "HelloService",
        portName = "HelloServicePort",
        endpointInterface = "com.example.tp12_service_soap_apache_cxf.api.HelloService",
        targetNamespace = "http://api.cxf.acme.com/"
)
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Bonjour, " + (name == null ? "inconnu" : name);
    }

    @Override
    public Person findPersonById(String id) {
        return new Person(id, "Ada Lovelace", 36); // maquette
    }
}