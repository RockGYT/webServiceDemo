/**
 * FileName: DemoServiceImpl
 * Author:   Rock_Guo
 * Date:     2018/6/14 14:32
 * Description: webService服务端demo
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package demo.service.impl;

import demo.service.DemoService;

/**
 * 〈一句话功能简述〉<br> 
 * 〈webService服务端demo〉
 *
 * @author Rock_Guo
 * @create 2018/6/14
 * @since 1.0.0
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String callService(String message) {
        //System.out.println(message);
        return message + " \n Hi Client,  I'm CXFService ! ";
    }
}
