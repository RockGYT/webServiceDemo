/**
 * FileName: AXISClient
 * Author:   Rock_Guo
 * Date:     2018/6/15 13:39
 * Description: AXIS客户端
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package client.axisClient;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.message.SOAPHeaderElement;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

/**
 * 〈一句话功能简述〉<br> 
 * 〈AXIS客户端〉
 *
 * @author Rock_Guo
 * @create 2018/6/15
 * @since 1.0.0
 */
public class AXISClient {

    public void callService() {

        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress("http://localhost:8080/webService/cxf/cxf-service?wsdl");

            // 添加身份人认证信息  begin
            String namespace = "http://service.demo/";//命名空间
            SOAPHeaderElement header = new SOAPHeaderElement(namespace,"AuthToken");
            header.setPrefix("");//前缀
            header.addChildElement("username").addTextNode("puan.zhangsan");
            header.addChildElement("password").addTextNode("123456");
            call.addHeader(header);
            // 添加身份人认证信息  end


            // 调用的方法名
            //call.setOperationName("callService");
            call.setOperationName(new QName(namespace, "callService"));

            // 设置参数名（根据wsdl中的参数名称配置，若服务端没有使用WebParam指定参数名，则默认是 arg0、arg1、arg2......）
            call.addParameter("arg0",   // 参数名
                    XMLType.XSD_STRING, // 参数类型:String
                    ParameterMode.IN);  // 参数模式：'IN' or 'OUT'
            // 设置返回值类型
            call.setReturnType(XMLType.XSD_STRING); // 返回值类型：String
            String requestParam = "Hi Service, I'm AXISClient !";
            String result = (String) call.invoke(new Object[]{requestParam});// 远程调用
            System.out.println(result);
        }catch (Exception e){
            System.out.println("AXISClient Exception: " + e.getMessage());
        }
    }
}
