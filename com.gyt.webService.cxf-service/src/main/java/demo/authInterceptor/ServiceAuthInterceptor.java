/**
 * FileName: ServiceAuthInterceptor
 * Author:   Rock_Guo
 * Date:     2018/6/14 15:48
 * Description: 服务端登陆认证
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package demo.authInterceptor;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

/**
 * 〈一句话功能简述〉<br> 
 * 〈服务端登陆认证〉
 *
 * @author Rock_Guo
 * @create 2018/6/14
 * @since 1.0.0
 */
public class ServiceAuthInterceptor extends AbstractPhaseInterceptor<SoapMessage>  {

    public static final String USER_NAME = "puan.zhangsan";
    public static final String PASS_WORD = "123456";

    private SAAJInInterceptor saa = new SAAJInInterceptor();

    public ServiceAuthInterceptor() {
        super(Phase.PRE_PROTOCOL);
        getAfter().add(SAAJInInterceptor.class.getName());
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        SOAPMessage soapMsg = message.getContent(SOAPMessage.class);
        if (soapMsg == null) {
            saa.handleMessage(message);
            soapMsg = message.getContent(SOAPMessage.class);
        }
        SOAPHeader header = null;
        try {
            header = soapMsg.getSOAPHeader();

            NodeList userNodes = header.getElementsByTagName("username");
            NodeList passNodes = header.getElementsByTagName("password");

            //用户密码权限效验
            if (userNodes != null && passNodes != null) {
                Node userNode = userNodes.item(0);
                Node passNode = passNodes.item(0);

                if (userNode.getFirstChild() != null
                        && passNode.getFirstChild() != null
                        && userNode.getFirstChild().getNodeValue() != null
                        && passNode.getFirstChild().getNodeValue() != null) {

                    String username = userNode.getFirstChild().getNodeValue();
                    String pwd = passNode.getFirstChild().getNodeValue();

                    if(USER_NAME.equals(username) && PASS_WORD.equals(pwd)){
                        return;
                    }
                }
            }
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        throw new Fault(new Exception("认证失败，请核实用户名和密码！"));
    }
}
