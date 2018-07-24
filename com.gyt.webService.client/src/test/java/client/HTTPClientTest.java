/**
 * FileName: HTTPClientTest
 * Author:   Rock_Guo
 * Date:     2018/6/21 14:29
 * Description: http客户端测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package client;

import client.httpClient.HTTPClient;
import org.junit.Test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈http客户端测试〉
 *
 * @author Rock_Guo
 * @create 2018/6/21
 * @since 1.0.0
 */
public class HTTPClientTest {


    @Test
    // 测试soap 1.1 发送消息
    public void callService_soap1_1(){
        HTTPClient client = new HTTPClient();
        client.callService_soap1_1();
    }

}
