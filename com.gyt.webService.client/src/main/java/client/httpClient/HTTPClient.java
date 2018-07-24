/**
 * FileName: HTTPClient
 * Author:   Rock_Guo
 * Date:     2018/6/21 13:30
 * Description: 不依赖axis/cxf等框架，直接使用http客户端
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package client.httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;

/**
 * 〈一句话功能简述〉<br> 
 * 〈不依赖axis/cxf等框架，直接使用http客户端〉
 *
 * @author Rock_Guo
 * @create 2018/6/21
 * @since 1.0.0
 */
public class HTTPClient {

    // WSDL地址
    private static final String WSDL_ADDRESS = "http://localhost:8080/webService/cxf/cxf-service?wsdl";
    // 命名空间
    private static final String NAME_SPACE = "http://service.demo/";
    // 接口方法名
    private static final String METHOD_NAME = "callService";
    // 请求超时时间
    private static final int SOCKET_TIMEOUT = 30000;
    // 传输超时时间
    private static final int CONNECT_TIMEOUT = 30000;

    /**
     * 使用soap1.1发送消息
     */
    public void callService_soap1_1(){

        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(WSDL_ADDRESS);

        //  设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(SOCKET_TIMEOUT)
                .setConnectTimeout(CONNECT_TIMEOUT).build();
        httpPost.setConfig(requestConfig);

        try {
            httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");
            httpPost.setHeader("SOAPAction", METHOD_NAME);
            StringEntity data = new StringEntity(intiSoapXml(),
                    Charset.forName("UTF-8"));
            httpPost.setEntity(data);
            CloseableHttpResponse response = closeableHttpClient
                    .execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                // 打印响应内容
                String result = EntityUtils.toString(httpEntity, "UTF-8");
                // result 是完整的反馈报文，需要手动解析xml，获取我们需要的返回信息
                int start = result.indexOf("<return>");
                int end = result.indexOf("</return>");




            }
            // 释放资源
            closeableHttpClient.close();
        } catch (Exception e) {
            System.out.println(" HTTPClient soap1.1 请求异常，");
        }

    }

    /**
     * 使用soap1.2发送消息
     */
    public void callService_soap1_2(){

    }

    /**
     * 手动拼接请求报文
     * 可通过soapUI等工具生成后修改
     * @return
     */
    private String intiSoapXml(){
        StringBuffer soap = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        soap.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.demo/\">");
        soap.append("<soapenv:Header>");
        soap.append("<AuthToken xmlns=\"http://service.demo/\">");
        soap.append("<username>puan.zhangsan</username>");
        soap.append("<password>123456</password>");
        soap.append("</AuthToken>");
        soap.append("</soapenv:Header>");
        soap.append("<soapenv:Body>");
        soap.append("<ser:callService>");
        soap.append("<ser:arg0> Hi Service, I'm HTTPClient ! </ser:arg0>");
        soap.append("</ser:callService>");
        soap.append("</soapenv:Body>");
        soap.append("</soapenv:Envelope>");

        return soap.toString();
    }

}
