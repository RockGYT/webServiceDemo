/**
 * FileName: ClientAuthInterceptor
 * Author:   Rock_Guo
 * Date:     2018/6/14 15:14
 * Description: 客户端用户验证
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package authInterceptor;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈客户端用户验证〉
 *
 * @author Rock_Guo
 * @create 2018/6/14
 * @since 1.0.0
 */
public class ClientAuthInterceptor extends AbstractSoapInterceptor {

    public ClientAuthInterceptor() {
        super(Phase.WRITE);
    }

    @Override
    public void handleMessage(SoapMessage soapMessage) throws Fault {
        Document doc = DOMUtils.createDocument();
        // 根节点
        Element rootEle = doc.createElementNS("", "AuthToken");
        // 用户ID
        Element userEle = doc.createElement("username");
        userEle.setTextContent("puan.zhangsan");
        rootEle.appendChild(userEle);
        // 密码
        Element passEle = doc.createElement("password");
        passEle.setTextContent("123456789");
        rootEle.appendChild(passEle);

        // 添加到头
        List<Header> headers = soapMessage.getHeaders();
        QName qname = new QName("AuthToken");
        SoapHeader head = new SoapHeader(qname, rootEle);
        headers.add(head);
    }
}
