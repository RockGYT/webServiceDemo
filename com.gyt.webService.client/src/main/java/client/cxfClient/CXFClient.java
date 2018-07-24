/**
 * FileName: CXFClient
 * Author:   Rock_Guo
 * Date:     2018/6/14 15:45
 * Description: cxf方式客户端访问
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package client.cxfClient;

import authInterceptor.ClientAuthInterceptor;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * 〈一句话功能简述〉<br> 
 * 〈cxf方式客户端访问〉
 *
 * @author Rock_Guo
 * @create 2018/6/14
 * @since 1.0.0
 */
public class CXFClient {

    public void callService(){
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/webService/cxf/cxf-service?wsdl");
        client.getOutInterceptors().add(new ClientAuthInterceptor());
        client.getOutInterceptors().add(new LoggingOutInterceptor());
        Object[] result = null;

        try {
            result = client.invoke("callService","Hi Service,  I'm CXFClient ! ");
            System.out.println(result[0].toString());
        } catch (Exception e) {
            System.out.println("访问异常："+e.getMessage());
        }
    }

}
