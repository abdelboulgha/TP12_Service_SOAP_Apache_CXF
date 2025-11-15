package com.example.tp12_service_soap_apache_cxf.api;



import com.example.tp12_service_soap_apache_cxf.model.Person;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService(targetNamespace = "http://api.cxf.acme.com/")
public interface HelloService {
    @WebMethod(operationName = "SayHello")
    @WebResult(name = "greeting")
    String sayHello(@WebParam(name = "name") String name);

    @WebMethod(operationName = "FindPerson")
    @WebResult(name = "person")
    Person findPersonById(@WebParam(name = "id") String id);
}
