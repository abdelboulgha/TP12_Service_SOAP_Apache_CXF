package com.example.tp12_service_soap_apache_cxf.client;




import javax.xml.namespace.QName;

import com.example.tp12_service_soap_apache_cxf.api.HelloService;
import jakarta.xml.ws.Service;
import java.net.URL;

public class ClientDemo {
    public static void main(String[] args) throws Exception {
        URL wsdl = new URL("http://localhost:8080/services/hello?wsdl");
        QName qname = new QName("http://api.cxf.acme.com/", "HelloService");
        Service svc = Service.create(wsdl, qname);
        HelloService port = svc.getPort(HelloService.class);

        System.out.println(port.sayHello("ClientJava"));
        System.out.println(port.findPersonById("P-777").getName());
    }
}
