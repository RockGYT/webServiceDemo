/**
 * FileName: CXFClientTest
 * Author:   Rock_Guo
 * Date:     2018/6/14 16:15
 * Description: 测试cxf客户端
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package client;

import client.cxfClient.CXFClient;
import org.junit.Test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试cxf客户端〉
 *
 * @author Rock_Guo
 * @create 2018/6/14
 * @since 1.0.0
 */



public class CXFClientTest {

    @Test
    public void callServiceTest(){
        CXFClient client = new CXFClient();
        client.callService();
    }

}
