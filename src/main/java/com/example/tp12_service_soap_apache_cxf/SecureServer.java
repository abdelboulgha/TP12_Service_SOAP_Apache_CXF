package com.example.tp12_service_soap_apache_cxf;

import com.example.tp12_service_soap_apache_cxf.impl.HelloServiceImpl;
import com.example.tp12_service_soap_apache_cxf.security.UTPasswordCallback;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import java.util.HashMap;
import java.util.Map;

public class SecureServer {
    public static void main(String[] args) {
        Map<String, Object> inProps = new HashMap<>();
        inProps.put("action", "UsernameToken");
        inProps.put("passwordType", "PasswordText");
        inProps.put("passwordCallbackRef", new UTPasswordCallback(Map.of("student", "secret123")));

        WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);

        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(HelloServiceImpl.class);
        factory.setAddress("http://localhost:8080/services/hello-secure");
        Server server = factory.create();
        server.getEndpoint().getInInterceptors().add(wssIn);

        System.out.println("Serveur sécurisé démarré !");
        System.out.println("Secure WSDL: http://localhost:8080/services/hello-secure?wsdl");
        System.out.println("Appuyez sur Ctrl+C pour arrêter le serveur...");
    }
}
