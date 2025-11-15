package com.example.tp12_service_soap_apache_cxf;




import com.example.tp12_service_soap_apache_cxf.impl.HelloServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {
    public static void main(String[] args) {
        String address = "http://localhost:8080/services/hello";
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(HelloServiceImpl.class);
        factory.setAddress(address);
        factory.create();

        System.out.println("Serveur démarré !");
        System.out.println("WSDL: " + address + "?wsdl");
        System.out.println("Appuyez sur Ctrl+C pour arrêter le serveur...");
    }
}
