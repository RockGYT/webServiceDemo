/**
 * FileName: AXIS2ClientTest
 * Author:   Rock_Guo
 * Date:     2018/6/21 8:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package client;

import client.axis2Client.AXIS2Client;
import org.junit.Test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Rock_Guo
 * @create 2018/6/21
 * @since 1.0.0
 */
public class AXIS2ClientTest {

    @Test
    public void callServiceTest(){
        AXIS2Client client = new AXIS2Client();
        client.callService();
    }

    @Test
    public void callService2Test(){
        AXIS2Client client = new AXIS2Client();
        client.callService2();
    }

}
