/**
 * FileName: AXISClientTest
 * Author:   Rock_Guo
 * Date:     2018/6/15 15:37
 * Description: AXIS1客户端测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package client;

import client.axisClient.AXISClient;
import org.junit.Test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈AXIS1客户端测试〉
 *
 * @author Rock_Guo
 * @create 2018/6/15
 * @since 1.0.0
 */
public class AXISClientTest {
    @Test
    public void callServiceTest(){
        AXISClient client = new AXISClient();
        client.callService();
    }
}
