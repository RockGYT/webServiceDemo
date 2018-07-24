package demo.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface DemoService {

    @WebMethod(action="callService")
    @WebResult(name="response")
    public String callService( @WebParam(name="arg0", targetNamespace="http://service.demo/") String message);

}
