package sys;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.swing.JFrame;

/**
 * 
 * 全局静态变量，包括系统使用者，历史页面栈，系统配置，等等。
 * @author Berry
 *
 */
public class GlobalVariables {

	//登陆验证成功后保存账户的信息,登陆后map要add两次，第一次add("type",String型的type),type取值"系统管理员"，"事例管理员","财务人员",
	//"捐助者"，第二次add("user",对应的以保存上信息的实体类).
	//退出后设为null
	Map<String,Object> userInfo=null;
	
	//应用程序的主窗体
	public static JFrame frame;
	
	

	
	
}
